package io.warp10.warpscriptDSL

//
// First WarpScript commands generator
//

fun main(args: Array<String>) {
    //println("Hello world!")

    var tmp = warpScript {
        allowVariableName(listOf("test", "token"))
        push("NOW")
        push("\'test\' STORE")
        drop()
        now()
        store("now")
        fetch(token= "token", selector="name")
        fetch("token2", "name", hashMapOf("key" to "value", "k2" to "3" ))
        fetch("token", "name", start = now(), end = "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "1550000", "-100")
        fetch("token", "loadToken", hashMapOf("key" to "value"), now(), "-100", true)
        bucketize(bucketizer = "bucketizer.max", bucketcount = 1L)
        bucketize(drop(), bucketizer = "bucketizer.max", bucketcount = 1L)

        bucketize(
                    bucketize(fetch("token", "test"), bucketizer = "bucketizer.max", bucketcount = 1L)
                , bucketizer = "bucketizer.max", bucketcount = 1L)

        bucketize(
                {
                    fetch("token", "test")
                    bucketize(
                            {
                                swap()
                                drop()
                                swap()
                            }, bucketizer = "bucketizer.min", bucketcount = 1L)
                }
                , bucketizer = "bucketizer.count", bucketcount = 1L)
        load("test")
        drop()

        fetch("token", "name", hashMapOf("key" to "value"), load("now"), "-100")
        timeShift(100)

        push("\'test\' STORE")
        timeShift("test",100)

        timeShift(100, {
                fetch("inside", "inside")
            }
        )

        evalMacro("test")
    }

    print(tmp)

}

//
// Warp Script init functions
//

fun warpScript(init: WarpScript.() -> Unit): WarpScript {
    val ws = WarpScript("ws")
    ws.init()
    return ws
}