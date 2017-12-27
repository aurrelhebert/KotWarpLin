package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Class to build a Bucketize function
//

class Bucketize {

    companion object {

        // Generate hashMap of native elements for a Bucketize function
        //
        // Initialize bucketize with it's main parameters:
        // Series input
        // a bucketizer function
        // the lastbucket parameter
        // the bucketspan parameter
        // bucketcount parameter
        //

        fun getNativeBucketizeParameters(input: String,
                                         bucketizer: Element?,
                                         lastBucket: Long = 0L,
                                         bucketspan: Long = 0L,
                                         bucketcount: Long = 0L
                                        ): HashMap<Number, Any> {


            val elements = hashMapOf<Number, Any>(1 to StringElement(input),
                    3 to lastBucket, 4 to bucketspan,
                    5 to bucketcount)
            if (bucketizer != null) {
                elements.put(2, bucketizer)
            }
            return elements
        }

        // Generate hashMap of elements for a Fetch function
        fun getElementBucketizeParameters(inputElements: Element.() -> Unit,
                                          bucketizerElements: Element.() -> Unit,
                                          lastBucketElements: Element.() -> Unit,
                                          bucketspanElements: Element.() -> Unit,
                                          bucketcountElements: Element.() -> Unit
                                         ): HashMap<Number, Element.() -> Unit> {
            val elements = hashMapOf<Number, Element.() -> Unit>(1 to inputElements, 2 to bucketizerElements,
                    3 to lastBucketElements, 4 to bucketspanElements, 5 to bucketcountElements)
            return elements
        }

        fun verifyBucketize(bucketizer: Element?, bucketizerElements: Element.() -> Unit, emptyLambda: Element.() -> Unit) {
            if (bucketizer==null && bucketizerElements == emptyLambda) {
                throw Exception("WarpScrip Syntax error for Bucketize function: expect a valid bucketizer")
            }
        }

        fun verifyBucketizeNative(bucketspan: Long, bucketcount: Long) {
            if (bucketspan == 0L && bucketcount == 0L ) {
                throw Exception("Inside BUCKETIZE framework, one of bucketspan or bucketcount must be different from zero")
            }
        }
    }
}