package io.warp10.warpscriptDSL

//
// TODO: update and change
//

abstract class ListTag (name: String) : FunctionElement(name) {

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


    //
    // Get current element child for a given entry
    //

    private fun getChilds(ws: WarpScript, entry: Element.() -> Unit): ArrayList<Element> {

        //
        // Initalize two empty list
        //

        var myWs = ArrayList<Element>()
        var currentWs = ArrayList<Element>()

        //
        // Save current state of the father node
        //

        myWs.addAll(ws.children)

        //
        // Apply all loader child
        //

        ws.entry()

        //
        // Delete all childs of parent node
        //

        currentWs.addAll(ws.children)
        currentWs.removeAll(myWs)
        currentWs.remove(this)

        //
        // Fill current loader of the removed elements
        //

        ws.children.removeAll(currentWs)

        return currentWs
    }

}