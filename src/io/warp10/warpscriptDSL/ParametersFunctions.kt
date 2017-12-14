package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Builder for all WarpScripts function using parameters
//

class ParametersFunctions : FunctionElement {

    // Constructor using a Map
    constructor(name: String, attributes: Map<Number, String>) : super(name) {
        this.attributes.putAll(attributes)
    }

    // Set a specific attribute for a function
    fun setAttributes(index: Long, value: String) {
        this.attributes.put(index, value)
    }

}