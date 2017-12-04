package io.warp10.warpscriptDSL

import org.omg.CORBA.Object

@WarpScriptTagMarker
abstract class Tag(val name: String) : Element {
    val children = arrayListOf<Element>()
    val attributes = hashMapOf<Number, String>()

    protected fun <T : Element> initTag(tag: T, init:  T.() -> Unit) : T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {

        // Load all render, and do not indent for basic WS
        for (c in children) {
            c.render(builder, "")
        }
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}