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


    var tmp = warpScript {
        allowVariableName(listOf("test", "token"))
        push("NOW")
        push("\'test\' STORE")
        drop()
        now()
        store("now")
        fetch(token= "token", selector="name")
        fetch("token2", "name", hashMapOf("key" to "value", "k2" to "3" ))
        //fetch("token", "name", start = now(), end = "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "1550000", "-100")
        //fetch("token", "loadToken", hashMapOf("key" to "value"), now(), "-100", true)
        bucketize(bucketizer = Bucketizer().max(), bucketcount = 1L)

        bucketize(loadElements =
                {
                    fetch("token", "test")
                    bucketize( loadElements =
                            {
                                swap()
                                drop()
                                swap()
                            }, bucketizer = Bucketizer().min(), bucketcount = 1L)
                }
                , bucketizer = Bucketizer().count(), bucketcount = 1L)
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

        fetch("token", "name", hashMapOf("key" to "value"),end= "-100")
        timeShift(100)

        push("\'test\' STORE")

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
        map(swap(), Mapper().add(2), 0, 0,1)

        map("titi", Mapper().abs(), 0, 0,1)

        map({
            fetch("token", "test")
            bucketize(loadElements =
                    {
                        swap()
                        drop()
                        swap()
                    }, bucketizer = Bucketizer().min(), bucketcount = 1L)
        }, Mapper().abs(), 0, 0,1)

        filter(swap(), ArrayList<String>(), Filter().byclass("myClass"))
        filter("test", ArrayList<String>(), Filter().byclass("myClass"))

        val test = HashMap<String,String>()
        test.put("2","label0")
        filter("test", ArrayList<String>(), Filter().bylabels(test))

        push(test)
        filter({
            fetch("token", "test")
            bucketize(loadElements =
                    {
                        swap()
                        drop()
                        swap()
                    }, bucketizer = Bucketizer().min(), bucketcount = 1L)
        }, ArrayList<String>(), Filter().byclass("myClass"))

        apply({
            fetch("token", "test")
            bucketize(loadElements =
                    {
                        swap()
                        drop()
                        swap()
                    }, bucketizer = Bucketizer().min(), bucketcount = 1L)
        }, ArrayList<String>(), Apply().and())

        timeShift(100)
        timeShift({load("test")})
        timeShift({
            timeShift( {
                now()
                load("test")
            })
            load("test")
        }, { now() })
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

