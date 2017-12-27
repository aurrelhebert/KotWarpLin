package io.warp10.warpscriptDSL

class StringElement(val name: String) : Element {

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent")
        builder.append("$name \n")
    }

    // Tag string rendering
    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}