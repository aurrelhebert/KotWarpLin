package io.warp10.samples

import io.warp10.warpscriptDSL.*

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Complete example that can be executed on a Warp 10 instance
//

fun main(args: Array<String>) {
    //println(true.toString())

    var tmp = WarpScript.generate {

        newGts()
        addValue(timestamp = 2, value = 3)
        addValue(timestamp = 3, value = 5)
        addValue(timestamp = 10, value = 5)
        bucketize(bucketizer = Bucketizer().max(), bucketcount = 1L)


        bucketize(loadElements =
        {
            bucketize(loadElements =
            {
                rot()
            }, bucketizer = Bucketizer().min(), bucketcount = 1L)
        }
                , bucketizer = Bucketizer().count(), bucketcount = 1L)

        map(loadElements = { swap() }, mapper = Mapper().add(2), pre = 0, post = 0, occurrences = 0)

        //fetch(parameters = {
        //  now()
        //})
        add(2, 3)
        add(p2Elements = { now() })
        pi()
    }

    var output = WarpScript.exec(tmp, "http://127.0.0.1:8080/api/v0/exec")

    println(output.toJsonString(true))
}
