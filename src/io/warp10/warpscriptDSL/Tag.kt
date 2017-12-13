package io.warp10.warpscriptDSL

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
}
