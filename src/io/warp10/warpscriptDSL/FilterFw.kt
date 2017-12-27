package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Filter framework builder
//

class FilterFw {

    companion object {

        // Generate hashMap of native elements for a Filter function
        //
        // Initialize filter with it's main parameters:
        // Series input
        // Labels for equivalence class
        // Filter operator
        //

        fun getNativeFilterParameters(input: String,
                                         labels: List<Any>,
                                         filter: Element?
                                        ): HashMap<Number, Any> {


            val elements = hashMapOf<Number, Any>(1 to StringElement(input),
                    2 to StringElement(FunctionElement.getListString(labels)))
            if (filter != null) {
                elements.put(3, filter)
            }
            return elements
        }

        // Generate hashMap of elements for a Fetch function
        fun getElementFilterParameters(inputElements: Element.() -> Unit,
                                       labelsElements: Element.() -> Unit,
                                       filterElements: Element.() -> Unit
        ): HashMap<Number, Element.() -> Unit> {
            val elements = hashMapOf<Number, Element.() -> Unit>(1 to inputElements, 2 to labelsElements,
                    3 to filterElements)
            return elements
        }

        fun verifyFilter(filter: Element?, filterElements: Element.() -> Unit, emptyLambda: Element.() -> Unit) {
            if (filter==null && filterElements == emptyLambda) {
                throw Exception("WarpScrip Syntax error for Bucketize function: expect a valid bucketizer")
            }
        }
    }
}
