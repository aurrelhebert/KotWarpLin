package io.warp10.warpscriptDSL

//
// Class to call when user want to push custom WarpScript elements on the stack
//

class Push : FunctionElement {

    // Variable to store name attribute --> always in first position
    var data: String
        get() = attributes[0]!!
        set(value) {
            attributes.put(0, value)
        }

    // Constructors
    fun setAttr(data : String) {
        this.data="$" + data
    }

    constructor() : super("STORE")

    constructor(data: String) : super("") {
        this.data=data
    }
}