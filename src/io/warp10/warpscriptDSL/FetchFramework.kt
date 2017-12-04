package io.warp10.warpscriptDSL

interface FetchFramework {

    fun fetch(token: String, init: Fetch.() -> Unit);
}