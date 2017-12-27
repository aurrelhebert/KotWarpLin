package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Mapper framework builder
//

class MapFw {

    companion object {

        // Generate hashMap of native elements for a Map function
        //
        // Initialize Map with it's main parameters:
        // input Series
        // a map function
        // the pre parameter
        // the post parameter
        // an occurrences parameter
        //
        //

        fun getNativeMapParameters(input: String,
                                         mapper: Element?,
                                         pre: Long = 0L,
                                         post: Long = 0L,
                                         occurrences: Long = 0L
        ): HashMap<Number, Any> {


            val elements = hashMapOf<Number, Any>(1 to StringElement(input),
                    3 to pre, 4 to post,
                    5 to occurrences)
            if (mapper != null) {
                elements.put(2, mapper)
            }
            return elements
        }

        // Generate hashMap of elements for a Fetch function
        fun getElementMapParameters(inputElements: Element.() -> Unit,
                                    mapperElements: Element.() -> Unit,
                                    preElements: Element.() -> Unit,
                                    postElements: Element.() -> Unit,
                                    occurrencesElements: Element.() -> Unit
        ): HashMap<Number, Element.() -> Unit> {
            val elements = hashMapOf<Number, Element.() -> Unit>(1 to inputElements, 2 to mapperElements,
                    3 to preElements, 4 to postElements, 5 to occurrencesElements)
            return elements
        }

        fun verifyMapper(mapper: Element?, mapperElements: Element.() -> Unit, emptyLambda: Element.() -> Unit) {
            if (mapper==null && mapperElements == emptyLambda) {
                throw Exception("WarpScrip Syntax error for Bucketize function: expect a valid bucketizer")
            }
        }

    }
}
