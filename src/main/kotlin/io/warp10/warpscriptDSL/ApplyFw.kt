package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Apply framework builder
//

class ApplyFw : ListTag {

    //
    // Create an Apply framework
    // labels to create an equivalence class
    // Apply operator
    //

    private fun createFilter(labels: List<Any>, op: Element) {
        this.attributes.put(1, FunctionElement.getListString(labels))
        this.attributes.put(2, op.toString().removeSuffix("\n").removePrefix(" "))
    }

    // Apply rendering output
    override fun render(builder: StringBuilder, indent: String) {

        builder.append("$indent [ \n")

        if (!loader.isEmpty()) {
            for (items in loader) {
                items.render(builder,indent + "  ")
            }
        }

        for ((_,value) in attributes) {
            builder.append(indent + "   $value \n")
        }

        builder.append(indent + " ] $name\n")
    }

    // Constructor when loader is a String (variable)
    constructor(load: String = "SWAP",labels: List<Any>, op: Element) : super("APPLY") {

        this.attributes.put(0, load)
        this.createFilter(labels, op)
    }

    // Constructor when loader is an Element (function)
    constructor(load: Element,labels: List<Any>, op: Element) : super("APPLY") {

        //this.attributes.put(0, load.render())
        this.loader.add(load)
        this.createFilter(labels, op)
    }

    // Basic constructor
    constructor(labels: List<Any>, op: Element) : super("APPLY") {
        this.createFilter(labels, op)
    }
}
