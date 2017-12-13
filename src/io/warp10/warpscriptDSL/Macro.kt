package io.warp10.warpscriptDSL

class Macro : FunctionElement {

    val bodyArray = arrayListOf<Element>()

    override fun render(builder: StringBuilder, indent: String) {
        if (!bodyArray.isEmpty()) {

            builder.append("$indent <% \n")
            for (items in bodyArray) {
                items.render(builder,indent + "  ")
            }
            builder.append(indent + " %> \n")
        }
    }

    //
    // Function used to fill macro body code with all the child element of current Macro
    //

    fun applyBody(ws: WarpScript, entry: Element.() -> Unit) {
        this.bodyArray.addAll(this.getChilds(ws,entry))
    }

    constructor() : super("") {
    }
}