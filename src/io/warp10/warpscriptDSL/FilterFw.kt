package io.warp10.warpscriptDSL

class FilterFw : ListTag {

    private fun createFilter(filter: Element) {
        this.attributes.put(1, filter.toString().removeSuffix("\n").removePrefix(" "))
    }

    constructor(load: String = "SWAP", filter: Element) : super("FILTER") {

        this.attributes.put(0, load)
        this.createFilter(filter)
    }

    constructor(load: Element, filter: Element) : super("FILTER") {

        //this.attributes.put(0, load.render())
        this.loader.add(load)
        this.createFilter(filter)
    }

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

    constructor(filter: Element) : super("FILTER") {
        this.createFilter(filter)
    }
}
