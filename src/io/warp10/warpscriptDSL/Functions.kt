package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Class used to instantiate Singleton or parameters function
//

class Functions : FunctionElement {

    constructor(name: String, native: HashMap<Number, Any>,
                nativeElements: HashMap<Number, Element.() -> Unit>,
                ws: WarpScript,
                emptyLambda: Element.() -> Unit) : super (name, native, nativeElements, ws, emptyLambda) {
    }

    constructor(name: String) : super (name)
}