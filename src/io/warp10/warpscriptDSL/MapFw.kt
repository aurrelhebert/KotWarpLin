package io.warp10.warpscriptDSL

class MapFw : ListTag {

    private fun createMapper(mapper: Element, pre: Long = 0L, post: Long = 0L, occurrences: Long = 0L) {
        this.attributes.put(1, mapper.toString().removeSuffix("\n").removePrefix(" "))
        this.attributes.put(2, pre.toString())
        this.attributes.put(3, post.toString())
        this.attributes.put(4, occurrences.toString())
    }

    constructor(load: String = "SWAP", mapper: Element, pre: Long = 0L, post: Long = 0L, occurrences: Long = 0L) : super("MAP") {

        this.attributes.put(0, load)
        this.createMapper(mapper,pre,post,occurrences)
    }

    constructor(load: Element, mapper: Element, pre: Long = 0L, post: Long = 0L, occurrences: Long = 0L) : super("MAP") {

        //this.attributes.put(0, load.render())
        this.loader.add(load)
        this.createMapper(mapper,pre,post,occurrences)
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

    constructor(mapper: Element, pre: Long = 0L, post: Long = 0L, occurrences: Long = 0L) : super("MAP") {
        this.createMapper(mapper,pre,post,occurrences)
    }
}
