package io.warp10.warpscriptDSL

import java.util.*

//
// Fetch Framework class
//

class Fetch : ListTag("FETCH") {

    // Token attribute --> always in first position
    var token: String
        get() = attributes[0]!!
        set(value) {
            attributes.put(0, value)
        }

    // Selector attribute --> always in second position
    var selector: String
        get() = attributes[1]!!
        set(value) {
            attributes.put(1, value)
        }

    // Labels as string -> 3rd
    var labels: String
        get() = attributes[2]!!
        set(value) {
            attributes.put(2, value)
        }

    // Start date --> String
    var start: String
        get() = attributes[3]!!
        set(value) {
            attributes.put(3, value)
        }

    // End date --> String
    var end: String
        get() = attributes[4]!!
        set(value) {
            attributes.put(4, value)
        }

    // Constructors
    fun setAttr(token : String, selector : String) {
        this.setAttr(token, selector, HashMap(), "NOW", "-1")
    }

    fun setAttr(token : String, selector : String, end: String) {
        this.setAttr(token, selector, HashMap(), end)
    }

    fun setAttr(token : String, selector : String, start: String, end: String) {
        this.setAttr(token, selector, HashMap(), start, end)
    }

    fun setAttr(token : String, selector : String, labels : Map<String, String>) {
        this.setAttr(token, selector,labels, "NOW", "-1")
    }

    fun setAttr(token : String, selector : String, labels : Map<String, String>, end : String) {
        this.setAttr(token, selector, labels, "NOW", end)
    }

    fun setAttr(token : String, selector : String, labels : Map<String, String>, start : String, end : String) {
        this.token="\'" + token + "\'"
        this.selector="\'" + selector + "\'"
        this.labels= parseLabels(labels)

        //this.checkTicks(start, end)

        this.start=start
        this.end=end
    }

    fun setAttr(token : String, selector : String, labels : Map<String, String>, start : FunctionElement, end : String) {
        this.token="\'" + token + "\'"
        this.selector="\'" + selector + "\'"
        this.labels= parseLabels(labels)
        this.start = start.toString().removeSuffix("\n").removePrefix(" ")
        this.end=end
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

    //fun now(init: Now.

    fun now() = Now()
}