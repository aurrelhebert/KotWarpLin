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

    var tmp = WarpScript.generate {

        allowVariableName(listOf("test"))
        bucketize(bucketizer = Bucketizer().max(), bucketcount = 1L)


        bucketize(bucketizer = Bucketizer().max(), bucketcountElements = {
            swap()
            fetch(selector = "rien")
        }, bucketcount = 1L)

        bucketize(loadElements =
                {
                    fetch("token", "test")
                    bucketize(loadElements =
                            {
                                swap()
                                drop()
                                swap()
                            }, bucketizer = Bucketizer().min(), bucketcount = 1L)
                }
                , bucketizer = Bucketizer().count(), bucketcount = 1L)
        fetch( selectorElements = {
            load("test")
        })

        map(loadElements = { swap() }, mapper = Mapper().add(2), pre = 0, post = 0, occurrences = 1)

        //fetch(parameters = {
        //  now()
        //})
        add( 2, 3)
        add(p2Elements= { now() })
        pi()
        addValue(timestamp = 2, value = 3)
    }

    print(tmp)
}
