package io.warp10.warpscriptDSL

//
// Not used
//

class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String){
        builder.append("$indent$text")
    }
}