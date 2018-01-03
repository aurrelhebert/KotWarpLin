package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Apply framework builder
//

class ApplyFw {

    companion object {

        // Generate hashMap of native elements for an Apply function
        //
        // Initialize apply with it's main parameters:
        // Labels for equivalence class
        // Apply operator
        //

        fun getNativeApplyParameters(
                                      labels: List<Any>,
                                      op: Element?
        ): HashMap<Number, Any?> {

            val elements = hashMapOf<Number, Any?>(
                    2 to StringElement(FunctionElement.getListString(labels)))
            if (op != null) {
                elements.put(3, op)
            }
            return elements
        }

        // Generate hashMap of elements for a Fetch function
        fun getElementApplyParameters(inputElements: Element.() -> Unit,
                                       labelsElements: Element.() -> Unit,
                                       opElements: Element.() -> Unit
        ): HashMap<Number, Element.() -> Unit> {
            val elements = hashMapOf<Number, Element.() -> Unit>(1 to inputElements, 2 to labelsElements,
                    3 to opElements)
            return elements
        }

        // Verify operator validity
        fun verifyOperator(op: Element?, opElements: Element.() -> Unit, emptyLambda: Element.() -> Unit) {
            if (op==null && opElements == emptyLambda) {
                throw Exception("WarpScrip Syntax error for Apply function: expect a valid operator")
            }
        }
    }
}
