package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Class to call when user want to evaluate a WarpScript macro
//

class EvalMacro : FunctionElement {
    constructor(macro: String) : super ("@" + macro)
}
