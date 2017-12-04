package io.warp10.warpscriptDSL

//
// Not used
//

abstract class VariableElement(val name: String) : Element {

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent")
        builder.append("\$$name")
    }
}