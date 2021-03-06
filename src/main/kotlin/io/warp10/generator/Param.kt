package io.warp10.generator

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Internal type of the Parameter function
// name corresponds to a parameter key name
// type corresponds to it's Kotlin native type
//

class Param {
    var name: String
    var type: String
    var defaultValue: String? = null

    constructor(name: String, type: String) {
        this.name = name
        this.type = type
    }

    override fun toString(): String {
        return "Param(name='$name', type='$type')"
    }
}