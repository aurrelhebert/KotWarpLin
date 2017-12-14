package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// WarpScript DSL fail to load variable
//

class WarpScriptDSLException: Exception {

    constructor(failFunction: String, dataName: String) : super("WarpScrip Syntax error for " + failFunction + " function: " + dataName + " not found in saved variable")
}
