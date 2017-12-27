package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Main builder
//

abstract class Tag(val name: String) : Element {

    // Tag childs
    val children = arrayListOf<Element>()

    // Tag and child initialisation
    fun <T : Element> initTag(tag: T, init:  T.() -> Unit) : T {
        tag.init()
        children.add(tag)
        return tag
    }

    // Tag output builder rendering
    override fun render(builder: StringBuilder, indent: String) {

        // Load all render, and do not indent for basic WS
        for (c in children) {
            c.render(builder, indent + "")
        }
    }

    // Tag string rendering
    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
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
