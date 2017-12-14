package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Logic for IF WarpScript function
//

class IF : FunctionElement {

    // Conditional WarpScript elements
    var condArray = arrayListOf<Element>()

    // Case then WarpScript elements
    val thenArray = arrayListOf<Element>()

    // Case else WarpScript elements
    val elseArray = arrayListOf<Element>()

    // If output rendering
    override fun render(builder: StringBuilder, indent: String) {

        // Render conditional in a WarpScript Macro
        if (!condArray.isEmpty()) {

            builder.append("$indent <% \n")

            for (items in condArray) {
                items.render(builder,indent + "  ")
            }

            builder.append("$indent %> \n")
        }

        // Render then case in a second WarpScript Macro
        if (!thenArray.isEmpty()) {

            builder.append("$indent <% \n")
            for (items in thenArray) {
                items.render(builder,indent + "  ")
            }
            builder.append(indent + " %> \n")
        }

        // Render else case in a third WarpScript Macro (if existing)
        if (!elseArray.isEmpty()) {

            builder.append("$indent <% \n")
            for (items in elseArray) {
                items.render(builder,indent + "  ")
            }
            builder.append(indent + " %> \n")
        }


        builder.append(indent + " $name \n")
    }

    //
    // Function used to fill then code with all the child element of current IF
    //

    fun applyThen(ws: WarpScript, entry: Element.() -> Unit) {
        this.thenArray.addAll(this.getChilds(ws,entry))
    }

    //
    // Function used to fill conditional code with all the child element of current IF
    //

    fun applyCond(ws: WarpScript, entry: Element.() -> Unit) {
        this.condArray.addAll(this.getChilds(ws,entry))
    }

    //
    // Function used to fill else code with all the child element of current IF
    //

    fun applyElse(ws: WarpScript, entry: Element.() -> Unit) {
        this.elseArray.addAll(this.getChilds(ws,entry))
    }

    constructor(name: String, cond: Boolean) : super(name) {
        this.condArray.add(StandaloneFunction(cond.toString()))
    }

    constructor(name: String) : super(name) {
    }
}