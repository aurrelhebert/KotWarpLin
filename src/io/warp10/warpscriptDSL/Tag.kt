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
    val children = arrayListOf<Element>()

    fun <T : Element> initTag(tag: T, init:  T.() -> Unit) : T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {

        // Load all render, and do not indent for basic WS
        for (c in children) {
            c.render(builder, indent + "")
        }
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }

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
            sb.append(key + " " + value)
        }

        sb.append(" }")
        return sb.toString()
    }
}
