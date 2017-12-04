package io.warp10.warpscriptDSL


fun main(args: Array<String>) {
    //println("Hello world!")

    var tmp = warpScript {
        fetch("token", "name")
        fetch("token2", "name", hashMapOf("key" to "value", "k2" to "3" ))
        fetch("token", "name", "-100")
        fetch("token", "name","150000", "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "-100")
        fetch("token", "name", hashMapOf("key" to "value"), "15s0000", "-100")
    }

    print(tmp)

}

fun warpScript(init: WarpScript.() -> Unit): WarpScript {
    val ws = WarpScript("ws")
    ws.init()
    return ws
}