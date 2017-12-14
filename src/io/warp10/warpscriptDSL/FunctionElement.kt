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

    // Current function parameters
    val attributes = hashMapOf<Number, String>()

    // Build render for a WS function:
    override fun render(builder: StringBuilder, indent: String) {

        for ((_,value) in attributes) {
            builder.append(indent + " $value")
        }

        builder.append(indent + " $name \n")
    }

    // Current function output
    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }

    // Get current element child for a given entry
    protected fun getChilds(ws: WarpScript, entry: Element.() -> Unit): ArrayList<Element> {

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

    // Generate valid WarpScript for a Java Map
    protected fun <T, U> getMapString(map: Map<T, U>): String {

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

    // Generate valid WarpScript for a Java List
    protected fun <T> getListString(list: List<T>): String {

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
}