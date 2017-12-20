package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// First WarpScript commands generator
//

fun main(args: Array<String>) {
    //println(true.toString())


    var tmp = warp {

        bucketize(bucketizer = Bucketizer().max(), bucketcount = 1L)

        bucketize(
                {
                    fetch("token", "test")
                    bucketize(
                            {
                                swap()
                                drop()
                                swap()
                            }, Bucketizer().min(), bucketcount = 1L)
                }
                , bucketizer = Bucketizer().count(), bucketcount = 1L)
    }

    print(tmp)
}

//
// Warp Script init functions
//

fun warp(init: WarpScript.() -> Unit): WarpScript {
    val ws = WarpScript("ws")
    ws.init()
    return ws
}

