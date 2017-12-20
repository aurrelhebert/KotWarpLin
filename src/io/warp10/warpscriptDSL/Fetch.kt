package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

import kotlin.collections.HashMap

//
// Fetch Framework class
//

class Fetch : FunctionElement {

    private fun createFetch(token: String, selector: String, labels: String, start: String, end: String ) {

        this.pre = "["
        this.post = "]"

        this.setelements(hashMapOf<Number, Any>(  1 to StringElement(token), 2 to selector,
                3 to StringElement(labels), 4 to StringElement(start), 5 to StringElement(end)))
    }

    // Constructor using String as main loader
    constructor(token: String, selector: String, labels : Map<String, String> = HashMap(), start: Any = "_NOW", end: Any = -1) : super("FETCH") {
        this.createFetch(token,selector,this.parseLabels(labels),this.getTimeString(start), this.getTimeString(end))
    }

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