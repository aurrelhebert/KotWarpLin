package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Class to build a Bucketize function
//

class Bucketize: ListTag {

    //
    // Initialize bucketize with it's main parameters:
    // a bucketizer function
    // the lastbucket parameter
    // the bucketspan parameter
    // bucketcount parameter
    //

    private fun createBucketize(bucketizer: Element, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L) {
        if (bucketspan == 0L && bucketcount == 0L ) {
            throw Exception("Inside BUCKETIZE framework, one of bucketspan or bucketcount must be different from zero")
        }

        this.attributes.put(1, bucketizer.toString().removeSuffix("\n").removePrefix(" "))
        this.attributes.put(2, lastBucket.toString())
        this.attributes.put(3, bucketspan.toString())
        this.attributes.put(4, bucketcount.toString())
    }

    // Bucketize rendering output
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

    // Constructor using String as main loader
    constructor(load: String = "SWAP", bucketizer: Element, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L) : super("BUCKETIZE") {

        this.attributes.put(0, load)
        this.createBucketize(bucketizer,lastBucket,bucketspan,bucketcount)
    }

    // Constructor using an Element as Loader
    constructor(load: Element, bucketizer: Element, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L) : super("BUCKETIZE") {

        //this.attributes.put(0, load.render())
        this.loader.add(load)
        this.createBucketize(bucketizer,lastBucket,bucketspan,bucketcount)
    }

    // Bucketize main element init
    constructor(bucketizer: Element, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L) : super("BUCKETIZE") {
        this.createBucketize(bucketizer,lastBucket,bucketspan,bucketcount)
    }
}