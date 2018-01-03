package io.warp10.samples

import io.warp10.warpscriptDSL.*

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// WarpScript chain commands example
// This code only show how to use the Kotlin syntax in the DSL
// This example will not run on a Warp 10 instance
//

fun main(args: Array<String>) {
    //println(true.toString())

    var tmp = WarpScript.generate {
        now()
        allowVariableName(listOf("test", "token"))
        push("NOW")
        push("\'test\' STORE")
        drop()
        now()
        store("now")
        fetch(token = "token", selector = "name")
        fetch("token2", "name", hashMapOf("key" to "value", "k2" to "3"))
        //fetch("token", "name", start = now(), end = "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "1550000", "-100")
        //fetch("token", "loadToken", hashMapOf("key" to "value"), now(), "-100", true)
        bucketize(bucketizer = Bucketizer().max(), bucketcount = 1L)

        bucketize(loadElements =
        {
            fetch("token", "test")
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

        fetch("token", "name", hashMapOf("key" to "value"), end = "-100")
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
        map(loadElements = { swap() }, mapper = Mapper().add(2), pre = 0, post = 0, occurrences = 1)

        map("\$titi", Mapper().abs(), 0, 0, 1)

        map(loadElements = {
            fetch("token", "test")
            bucketize(loadElements =
            {
                swap()
                drop()
                swap()
            }, bucketizer = Bucketizer().min(), bucketcount = 1L)
        }, mapper = Mapper().abs(), pre = 0, post = 0, occurrences = 1)

        filter(loadElements = { swap() }, labels = ArrayList<String>(), filterFun = Filter().byclass("myClass"))
        filter("test", ArrayList<String>(), Filter().byclass("myClass"))

        val test = HashMap<String, String>()
        test.put("2", "label0")
        filter("test", ArrayList<String>(), Filter().bylabels(test))

        push(test)
        filter(loadElements = {
            fetch("token", "test")
            bucketize(loadElements =
            {
                swap()
                drop()
                swap()
            }, bucketizer = Bucketizer().min(), bucketcount = 1L)
        }, labels = ArrayList<String>(), filterFun = Filter().byclass("myClass"))

        apply(loadElements = {
            fetch("token", "test")
            bucketize(loadElements =
            {
                swap()
                drop()
                swap()
            }, bucketizer = Bucketizer().min(), bucketcount = 1L)
        }, labels = ArrayList<String>(), op= Apply().and())

        timeShift(100)
        timeShift({ load("test") })
        timeShift({
            timeShift({
                now()
                load("test")
            })
            load("test")
        }, { now() })
        pi()
    }

    print(tmp)
}

//
// Warp Script init functions
//

// fun warpScript(init: WarpScript.() -> Unit): WarpScript {
//    val ws = WarpScript("ws")
//    ws.init()
//    return ws
// }

