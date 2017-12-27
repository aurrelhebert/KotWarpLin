package io.warp10.warpscriptDSL

class Functions : FunctionElement {

    constructor(name: String, native: HashMap<Number, Any>,
                nativeElements: HashMap<Number, Element.() -> Unit>,
                ws: WarpScript,
                emptyLambda: Element.() -> Unit) : super (name, native, nativeElements, ws, emptyLambda) {
    }

    constructor(name: String) : super (name)
}