package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Reduce framework builder
//

class ReduceFw {

    companion object {

        // Generate hashMap of native elements for a Reduce function
        //
        // Initialize reduce with it's main parameters:
        // Labels for equivalence class
        // Reducer operator
        //

        fun getNativeReduceParameters(
                labels: List<Any>,
                reduce: Element?
        ): HashMap<Number, Any?> {

            val elements = hashMapOf<Number, Any?>(
                    2 to StringElement(FunctionElement.getListString(labels)))
            if (reduce != null) {
                elements.put(3, reduce)
            }
            return elements
        }

        // Generate hashMap of elements for a Fetch function
        fun getElementReduceParameters(inputElements: Element.() -> Unit,
                                      labelsElements: Element.() -> Unit,
                                      reduceElements: Element.() -> Unit
        ): HashMap<Number, Element.() -> Unit> {
            val elements = hashMapOf<Number, Element.() -> Unit>(1 to inputElements, 2 to labelsElements,
                    3 to reduceElements)
            return elements
        }

        // Verify reducer validity
        fun verifyReducer(reduce: Element?, reducerElements: Element.() -> Unit, emptyLambda: Element.() -> Unit) {
            if (reduce==null && reducerElements == emptyLambda) {
                throw Exception("WarpScrip Syntax error for Reduce function: expect a valid reducer")
            }
        }
    }
}