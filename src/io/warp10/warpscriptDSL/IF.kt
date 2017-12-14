package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

class IF : FunctionElement {

    var condArray = arrayListOf<Element>()

    val thenArray = arrayListOf<Element>()

    val elseArray = arrayListOf<Element>()

    override fun render(builder: StringBuilder, indent: String) {


        if (!condArray.isEmpty()) {

            builder.append("$indent <% \n")

            for (items in condArray) {
                items.render(builder,indent + "  ")
            }

            builder.append("$indent %> \n")
        }

        if (!thenArray.isEmpty()) {

            builder.append("$indent <% \n")
            for (items in thenArray) {
                items.render(builder,indent + "  ")
            }
            builder.append(indent + " %> \n")
        }

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