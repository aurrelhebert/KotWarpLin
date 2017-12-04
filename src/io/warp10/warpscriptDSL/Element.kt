package io.warp10.warpscriptDSL

interface Element {
    fun render(builder: StringBuilder, indent: String)
}