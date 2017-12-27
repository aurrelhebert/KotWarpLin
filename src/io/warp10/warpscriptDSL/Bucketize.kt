package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Class to build a Bucketize function
//

class Bucketize: FunctionElement {

    //
    // Initialize bucketize with it's main parameters:
    // a bucketizer function
    // the lastbucket parameter
    // the bucketspan parameter
    // bucketcount parameter
    //

    private fun createBucketize(bucketizer: Element?, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L) {

        if (bucketspan == 0L && bucketcount == 0L ) {
            throw Exception("Inside BUCKETIZE framework, one of bucketspan or bucketcount must be different from zero")
        }

        this.pre = "["
        this.post = "]"

        this.setelements(hashMapOf<Number, Any>(  3 to lastBucket,
                4 to bucketspan, 5 to bucketcount))

        if (bucketizer != null) {
            this.setelements(hashMapOf<Number, Any>(  2 to bucketizer))
        }

    }

    // Constructor using String as main loader
    constructor(load: String = "SWAP", bucketizer: Element?, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L) : super("BUCKETIZE") {

        this.setelements(hashMapOf<Number, Any>(1 to StringElement(load)))
        this.createBucketize(bucketizer,lastBucket,bucketspan,bucketcount)
    }

    constructor() : super("BUCKETIZE")

    fun updateInputSeries(ws: WarpScript, entry: Element.() -> Unit) {
        this.applyLoader(ws, entry, 1)
    }

    fun updateBucketizer(ws: WarpScript, entry: Element.() -> Unit) {
        this.applyLoader(ws, entry, 2)
    }

    fun updateLastBucket(ws: WarpScript, entry: Element.() -> Unit) {
        this.applyLoader(ws, entry, 3)
    }

    fun updateBucketSpan(ws: WarpScript, entry: Element.() -> Unit) {
        this.applyLoader(ws, entry, 4)
    }

    fun updateBucketCount(ws: WarpScript, entry: Element.() -> Unit) {
        this.applyLoader(ws, entry, 5)
    }
}