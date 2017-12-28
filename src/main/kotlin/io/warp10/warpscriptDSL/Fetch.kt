package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

import kotlin.collections.HashMap

//
// Fetch Framework class utils function
//

class Fetch {

    companion object {

        // Generate hashMap of native elements for a Fetch function
        fun getNativeFetchParameters(token: String,
                                     selector: String,
                                     labels: Map<String, String>,
                                     start: Any,
                                     end: Any
                                    ): HashMap<Number, Any?> {
            val elements = hashMapOf<Number, Any?>(1 to token, 2 to selector,
                    3 to StringElement(Fetch.parseLabels(labels)), 4 to StringElement(this.getTimeString(start)),
                    5 to StringElement(this.getTimeString(end)))
            return elements
        }

        // Generate hashMap of elements for a Fetch function
        fun getElementsFetchParameters(tokenElements: Element.() -> Unit,
                                       selectorElements: Element.() -> Unit,
                                       labelsElements: Element.() -> Unit,
                                       startElements: Element.() -> Unit,
                                       endElements: Element.() -> Unit
                                      ): HashMap<Number, Element.() -> Unit> {
            val elements = hashMapOf<Number, Element.() -> Unit>(1 to tokenElements, 2 to selectorElements,
                    3 to labelsElements, 4 to startElements, 5 to endElements)
            return elements
        }

        fun verifyFetch(selector: String, selectorElement: Element.() -> Unit, emptyLambda: Element.() -> Unit) {
            if (selector=="_NONE" && selectorElement == emptyLambda) {
                throw Exception("WarpScrip Syntax error for FETCH function: expect a string selector")
            }
        }

        // Get Fetch time
        private fun getTimeString(time: Any): String {
            var returnString = ""
            if (time == "_NOW"){
                returnString = "NOW"
            } else if (time is Number) {
                returnString = time.toString()
            } else if (time is String) {
                returnString = "\'$time\'"
            } else {
                throw Exception ("Error in FETCH function, expects start and end to be number or string")
            }
            return returnString
        }

        // Convert labels to string
        private fun parseLabels(labels: Map<String, String>) : String {
            val sb = StringBuilder()

            sb.append("{")

            for ((key,value) in labels) {
                sb.append(" $key $value ")
            }
            sb.append("}")
            return sb.toString()
        }
    }
}