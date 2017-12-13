package io.warp10.warpscriptDSL

//
// Function builder
//
abstract class FunctionElement(val name: String) : Element {

    //
    // Function parameters
    //

    val attributes = hashMapOf<Number, String>()

    //
    // Build render for a WS function:
    //   param0
    //   param1
    //   FUNCTION
    //

    override fun render(builder: StringBuilder, indent: String) {

        for ((_,value) in attributes) {
            builder.append(indent + " $value")
        }

        builder.append(indent + " $name \n")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }


    //
    // Get current element child for a given entry
    //

    protected fun getChilds(ws: WarpScript, entry: Element.() -> Unit): ArrayList<Element> {

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