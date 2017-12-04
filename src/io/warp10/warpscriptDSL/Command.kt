package io.warp10.warpscriptDSL


fun main(args: Array<String>) {
    //println("Hello world!")

    var tmp = warpScript {
        now()
        fetch("token", "name")
        fetch("token2", "name", hashMapOf("key" to "value", "k2" to "3" ))
        //fetch("token", "name", now(), "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "1550000", "-100")
        fetch("token", "name", hashMapOf("key" to "value"), now(), "-100")
    }

    print(tmp)

}

fun warpScript(init: WarpScript.() -> Unit): WarpScript {
    val ws = WarpScript("ws")
    ws.init()
    return ws
}