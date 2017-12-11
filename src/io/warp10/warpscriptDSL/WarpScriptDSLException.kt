package io.warp10.warpscriptDSL

//
// WarpScript DSL fail to load variable
//

class WarpScriptDSLException: Exception {

    constructor(failFunction: String, dataName: String) : super("WarpScrip Syntax error for " + failFunction + " function: " + dataName + " not found in saved variable")
}
