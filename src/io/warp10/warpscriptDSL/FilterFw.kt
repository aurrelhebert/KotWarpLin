package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Filter framework builder
//

class FilterFw<T> : ListTag {

    //
    // Create a filter framework
    // labels to create an equivalence class
    // Filter operator
    //

    private fun createFilter(labels: List<T>, filter: Element) {
        this.attributes.put(1, this.getListString(labels))
        this.attributes.put(2, filter.toString().removeSuffix("\n").removePrefix(" "))
    }

    // Filter rendering output
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
    constructor(load: String = "SWAP",labels: List<T>, filter: Element) : super("FILTER") {

        this.attributes.put(0, load)
        this.createFilter(labels, filter)
    }

    // Constructor when loader is an Element (function)
    constructor(load: Element,labels: List<T>, filter: Element) : super("FILTER") {

        //this.attributes.put(0, load.render())
        this.loader.add(load)
        this.createFilter(labels, filter)
    }

    // Basic constructor
    constructor(labels: List<T>, filter: Element) : super("FILTER") {
        this.createFilter(labels, filter)
    }
}
