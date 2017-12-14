package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Basic element
//

interface Element {
    fun render(builder: StringBuilder, indent: String)
}