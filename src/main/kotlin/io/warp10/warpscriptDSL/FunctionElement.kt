package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Function builder
//

abstract class FunctionElement(val name: String) : Element {

    companion object {

        // Generate valid WarpScript for a Java List
        fun <T> getListString(list: List<T>): String {

            // Case empty List
            if (list.isEmpty()) {
                return  "[]"
            }

            // Open stringBuilder and list
            val sb = StringBuilder()
            sb.append("[ ")

            // Append each list items
            list.forEach {
                t ->
                var value = t.toString()
                if ( t is String) {
                    value = "\'$t\'"
                }
                sb.append(value + " ")
            }

            // Close List and return value
            sb.append("]")
            return sb.toString()
        }

        // Generate valid WarpScript for a Java Map
        fun <T, U> getMapString(map: Map<T, U>): String {

            // Case empty Map
            if (map.isEmpty()) {
                return  "{}"
            }

            // Open stringBuilder and map
            val sb = StringBuilder()
            sb.append("{ ")

            // Append each map keys and value
            map.forEach {
                t, u ->
                var key = t.toString()
                if ( t is String) {
                    key = "\'$t\'"
                }
                var value = u.toString()
                if ( u is String) {
                    key = "\'$t\'"
                }
                sb.append(key + " " + value + " ")
            }

            // Close Map and return value
            sb.append("}")
            return sb.toString()
        }
    }

    // Current function parameters
    val attributes = hashMapOf<Number, String>()
    val attributesElements = hashMapOf<Number, ArrayList<Element>>()
    var pre: String = ""
    var post: String = ""

    // Build render for a WS function:
    override fun render(builder: StringBuilder, indent: String) {

        if (!attributes.isEmpty()) {
            for ((_, value) in attributes) {
                builder.append(indent + "$value ")
            }
        }

        if (pre != "") {
            builder.append(indent + pre + "\n")
        }

        if (!attributesElements.isEmpty()) {
            for ((_,value) in attributesElements) {
                if (!value.isEmpty()) {
                    for (items in value) {
                        items.render(builder,   indent + "  ")
                    }
                }
            }
        }

        if (post != "") {
            builder.append(indent + post + "\n")
        }

        builder.append(indent + "$name")
        builder.append("\n")
    }

    // Current function output
    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }

    // Get current element child for a given entry
    fun getChilds(ws: WarpScript, entry: Element.() -> Unit): ArrayList<Element> {

        //
        // Initalize two empty list
        //

        var myWs = ArrayList<Element>()
        var currentWs = ArrayList<Element>()

        //
        // Save current state of the father node
        //

        myWs.addAll(ws.children)

        //
        // Apply all loader child
        //

        ws.entry()

        //
        // Delete all childs of parent node
        //

        currentWs.addAll(ws.children)
        currentWs.removeAll(myWs)
        currentWs.remove(this)

        //
        // Fill current loader of the removed elements
        //

        ws.children.removeAll(currentWs)

        return currentWs
    }

    // Add Kotlin native elements into attributes elements
    fun setelements(mapElements: Map<Number, Any?>) {

        for ((key,mapValue) in mapElements) {
            val elements = ArrayList<Element>()
            var value: String

            if (mapValue == null) {
                continue
            }

            // For each native case
            if (mapValue is Number) {
                value = mapValue.toString()
            } else if (mapValue is String) {
                value = "\'$mapValue\'"
            } else if (mapValue is Boolean) {
                value = mapValue.toString()
            } else if (mapValue is List<*>) {
                value = getListString(mapValue)
            } else if (mapValue is Map<*,*>) {
                value = getMapString(mapValue)
            } else if (mapValue is StringElement) {
                value = mapValue.toString().removeSuffix("\n")
            } else if (mapValue is Element) {
                value = mapValue.toString().removeSuffix("\n")
            } else {
                throw Exception("Expect native type for a parameter: String, Number or Boolean")
            }

            //Add current parameter to attributes map
            elements.add(StringElement(value))
            this.attributesElements.put(key,elements)
        }
    }

    // Set a specific attribute for a function
    fun setAttributesElements(index: Number, value: ArrayList<Element>) {
        this.attributesElements.put(index, value)
    }

    //
    // Function used to fill loader of all the child element of the current List tag function
    //

    fun applyLoader(ws: WarpScript, entry: (Element.() -> Unit)?, key: Number) {
        if(null != entry) {
            val elements = ArrayList<Element>()
            elements.addAll(this.getChilds(ws, entry))
            this.setAttributesElements(key, elements)
        }
    }

    //
    // Constructor used to load elements parameters of a WarpScript function
    //

    constructor(name: String, native: HashMap<Number, Any?>,
                nativeElements: HashMap<Number, Element.() -> Unit>,
                ws: WarpScript,
                emptyLambda: Element.() -> Unit) : this(name){

        this.setelements(native)
        for ( element in nativeElements.keys ){
            val apply = nativeElements.get(element)

            if (null != nativeElements.get(element)) {
                if (apply != emptyLambda) {
                    this.applyLoader(ws, apply, element)
                }
            }
        }
    }
}