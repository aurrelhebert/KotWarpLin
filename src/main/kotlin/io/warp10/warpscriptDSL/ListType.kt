package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

// Class used to instantiate WarpScript function loading a list as first parameter
class ListType : FunctionElement {


    constructor(name: String, native: HashMap<Number, Any?>,
        nativeElements: HashMap<Number, Element.() -> Unit>,
        ws: WarpScript,
        emptyLambda: Element.() -> Unit) : super (name, native, nativeElements, ws, emptyLambda) {

        this.pre = "["
        this.post = "]"
    }

    constructor(name: String) : super (name)
}