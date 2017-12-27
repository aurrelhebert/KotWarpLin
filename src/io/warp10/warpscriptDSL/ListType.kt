package io.warp10.warpscriptDSL

class ListType : FunctionElement {


    constructor(name: String, native: HashMap<Number, Any>,
        nativeElements: HashMap<Number, Element.() -> Unit>,
        ws: WarpScript,
        emptyLambda: Element.() -> Unit) : super (name, native, nativeElements, ws, emptyLambda) {

        this.pre = "["
        this.post = "]"
    }

    constructor(name: String) : super (name)
}