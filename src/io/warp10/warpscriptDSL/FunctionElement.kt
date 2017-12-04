package io.warp10.warpscriptDSL

abstract class FunctionElement(val name: String) : Element {

    val attributes = hashMapOf<Number, String>()

    override fun render(builder: StringBuilder, indent: String) {

        for ((_,value) in attributes) {
            builder.append(" $value \n")
        }

        builder.append("$indent $name \n")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }

}