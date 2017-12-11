package io.warp10.warpscriptDSL

import java.util.jar.Attributes

class ParametersFunctions : FunctionElement {

    constructor(name: String, attributes: Map<Number, String>) : super(name) {
        this.attributes.putAll(attributes)
    }

    fun setAttributes(index: Long, value: String) {
        this.attributes.put(index, value)
    }

}