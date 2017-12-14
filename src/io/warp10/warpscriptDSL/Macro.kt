package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// WarpScript Macro builder
//

class Macro : FunctionElement {

    // Macro body elements
    val bodyArray = arrayListOf<Element>()

    // Macro output rendering
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

    // Basic constructor
    constructor() : super("") {
    }
}