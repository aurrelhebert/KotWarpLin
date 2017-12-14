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
    protected fun <T> getMapString(map: Map<T, T>): String {
        val sb = StringBuilder()

        sb.append("{ ")
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

        sb.append(" }")
        return sb.toString()
    }

    // Generate valid WarpScript for a Java List
    protected fun <T> getListString(list: List<T>): String {
        val sb = StringBuilder()

        sb.append("[ ")
        list.forEach {
            t ->
            var value = t.toString()
            if ( t is String) {
                value = "\'$t\'"
            }
            sb.append(value + " ")
        }

        sb.append(" ]")
        return sb.toString()
    }
}
