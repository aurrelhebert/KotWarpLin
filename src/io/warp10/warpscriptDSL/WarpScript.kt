package io.warp10.warpscriptDSL

//
// Kotlin WarpScript Lib
//

class WarpScript(name: String) : Tag(name) {

    //
    // Fetch framework
    //

    fun fetch(token: String, selector: String, init: Fetch.() -> Unit = {}) {
        val fetch = initTag(Fetch(), init)
        fetch.setAttr(token, selector)
    }

    fun fetch(token: String, selector: String, labels: Map<String, String>, init: Fetch.() -> Unit = {}) {
        val fetch = initTag(Fetch(), init)
        fetch.setAttr(token, selector, labels)
    }

    fun fetch(token: String, selector: String, end: String, init: Fetch.() -> Unit = {}) {
        val fetch = initTag(Fetch(), init)
        fetch.setAttr(token, selector, end)
    }

    fun fetch(token: String, selector: String, start: String, end: String, init: Fetch.() -> Unit = {}) {
        val fetch = initTag(Fetch(), init)
        fetch.setAttr(token, selector, start, end)
    }

    fun fetch(token: String, selector: String, labels: Map<String, String>, end: String, init: Fetch.() -> Unit = {}) {
        val fetch = initTag(Fetch(), init)
        fetch.setAttr(token, selector, labels, end)
    }

    fun fetch(token: String, selector: String, labels: Map<String, String>, start: String, end: String, init: Fetch.() -> Unit = {}) {
        val fetch = initTag(Fetch(), init)
        fetch.setAttr(token, selector, labels, start, end)
    }

    fun fetch(token: String, selector: String, labels: Map<String, String>, start: FunctionElement, end: String, init: Fetch.() -> Unit = {}) {
        val fetch = initTag(Fetch(), init)
        this.children.remove(start)
        fetch.setAttr(token, selector, labels, start, end)
    }

    //
    // Single Now function
    //
    
    fun now() = initTag(Now(), {})
}