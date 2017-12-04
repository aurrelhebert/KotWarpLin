package io.warp10.warpscriptDSL

@WarpScriptTagMarker
abstract class StringElement(val name: String) : Element {

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent")
        builder.append("\'$name\'")
    }
}