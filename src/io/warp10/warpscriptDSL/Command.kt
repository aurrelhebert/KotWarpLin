package io.warp10.warpscriptDSL

//
// First WarpScript commands generator
//

fun main(args: Array<String>) {
    //println(true.toString())


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
        bucketize(bucketizer = Bucketizer.MAX, bucketcount = 1L)
        bucketize(drop(), bucketizer =  Bucketizer.MAX, bucketcount = 1L)

        bucketize(
                    bucketize(fetch("token", "test"), bucketizer = Bucketizer.MAX, bucketcount = 1L)
                , Bucketizer.MAX, bucketcount = 1L)

        bucketize(
                {
                    fetch("token", "test")
                    bucketize(
                            {
                                swap()
                                drop()
                                swap()
                            }, Bucketizer.MIN, bucketcount = 1L)
                }
                , bucketizer = Bucketizer.COUNT, bucketcount = 1L)
        load("test")
        drop()

        ifThen(true, {
            fetch("token", "test")
        })

        ifThen(false, {
            fetch("token", "test")
        })

        ifThen({
            now()
        }, {
            fetch("token", "test")
        })


        ifThenElse(true, {
            fetch("token", "test")
        },
                {
                    fetch("token", "test-2")
                })

        ifThenElse(false, {
            fetch("token", "test")
        },
                {
                    fetch("token", "test-2")
                })

        ifThenElse({
            now()
        }, {
            fetch("token", "test")
        },
                {
                    fetch("token", "test-2")
                })

        fetch("token", "name", hashMapOf("key" to "value"), load("now"), "-100")
        timeShift(100)

        push("\'test\' STORE")
        timeShift("test",100)

        timeShift(100, {
                fetch("inside", "inside")
            }
        )

        evalMacro("test")

        forW(0, 10, {
            now()
        })

        foreach({
            now()
        })

        lmap({
            now()
        })
        now()

        forStep(0, 10, {
            now()
            drop()
        }, {
            now()
        })

        whileW("test", "test")

        foreach("test")

        macro({
            now()
        })

        macro("titi", {
            now()
            drop()
        })

        evalMacro("titi")
        load("titi")
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