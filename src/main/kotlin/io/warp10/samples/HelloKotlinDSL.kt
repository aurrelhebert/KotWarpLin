package io.warp10.samples

import io.warp10.warpscriptDSL.WarpScript
import io.warp10.warpscriptDSL.*

//
// Simple Warp 10 Hello World
//

fun main(args: Array<String>) {

    //
    // Open WarpScript generator
    //

    var tmp = WarpScript.generate {

        // Apply WarpScript function now
        now()
    }

    var output = WarpScript.exec(tmp, "http://127.0.0.1:8080/api/v0/exec")

    println(output.toJsonString(true))
}