package io.warp10.warpscriptDSL

//
// Class to call when user want to evaluate a WarpScript macro
//

class EvalMacro : FunctionElement {
    constructor(macro: String) : super ("@" + macro)
}
