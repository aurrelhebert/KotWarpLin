package io.warp10.warpscriptDSL

//
// Basic element
//

interface Element {
    fun render(builder: StringBuilder, indent: String)
}