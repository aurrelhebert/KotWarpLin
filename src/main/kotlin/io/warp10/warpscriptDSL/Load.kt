package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Class to call when user want to load a WarpScript variable
//

class Load : FunctionElement {

    // Variable to store name attribute --> always in first position
    var load: String
        get() = attributes[0]!!
        set(value) {
            attributes.put(0, value)
        }

    // Constructors
    fun setAttr(load : String) {
        this.load="$" + load
    }

    constructor() : super("")

    constructor(load: String) : super("$" + load)

}