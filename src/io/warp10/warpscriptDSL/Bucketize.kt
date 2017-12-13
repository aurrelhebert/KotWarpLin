package io.warp10.warpscriptDSL

class Bucketize: ListTag {

    //
    // Function parameters
    //

    fun <T : Element> initTag(entry: Element.() -> Unit, tag: T, init:  T.() -> Unit) : T {
        //println(tag)
        tag.init()
        //children.add(tag)
        return tag
    }

    private fun createBucketize(bucketizer: Bucketizer, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0) {
        if (bucketspan == 0L && bucketcount == 0L ) {
            throw Exception("Inside BUCKETIZE framework, one of bucketspan or bucketcount must be different from zero")
        }

        this.attributes.put(1, bucketizer.value)
        this.attributes.put(2, lastBucket.toString())
        this.attributes.put(3, bucketspan.toString())
        this.attributes.put(4, bucketcount.toString())
    }

    constructor(load: String = "SWAP", bucketizer: Bucketizer, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L) : super("BUCKETIZE") {

        this.attributes.put(0, load)
        this.createBucketize(bucketizer,lastBucket,bucketspan,bucketcount)
    }

    constructor(load: Element, bucketizer: Bucketizer, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L) : super("BUCKETIZE") {

        //this.attributes.put(0, load.render())
        this.loader.add(load)
        this.createBucketize(bucketizer,lastBucket,bucketspan,bucketcount)
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

    constructor(bucketizer: Bucketizer, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L) : super("BUCKETIZE") {
        this.createBucketize(bucketizer,lastBucket,bucketspan,bucketcount)
    }
}