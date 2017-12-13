package io.warp10.warpscriptDSL

//
// TODO: update and change
//

abstract class ListTag (name: String) : FunctionElement(name) {

    val loader = arrayListOf<Element>()

    override fun render(builder: StringBuilder, indent: String) {

        //for (c in children) {
        //    c.render(builder,indent + "  ")
        //}

        builder.append("$indent [ \n")

        for ((_,value) in attributes) {
            builder.append(indent + "   $value \n")
        }

        builder.append(indent + " ] $name\n")
    }


    //
    // Function used to fill loader of all the child elemenet of the current List tag function
    //

    fun applyLoader(ws: WarpScript, entry: Element.() -> Unit) {
        this.loader.addAll(this.getChilds(ws,entry))
    }

}