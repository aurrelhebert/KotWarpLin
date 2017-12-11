package io.warp10.warpscriptDSL

//
// Kotlin WarpScript Lib
//

class WarpScript(name: String) : Tag(name) {

    var storedVariable = ArrayList<String>()

    //
    // Fetch framework
    //

    fun fetch(token: String = "READ", selector: String, labels: Map<String, String> = HashMap(), start: String = "NOW", end: String = "-1", loadToken: Boolean = false, init: Fetch.() -> Unit = {}): Fetch {
        var fetchToken = "\'" + token + "\'"

        if (loadToken) {
            if (storedVariable.contains(token)) {
                fetchToken = "$" + token
            } else {
                throw WarpScriptDSLException("FETCH",fetchToken)
            }
        }

        val fetch = initTag(Fetch(), init)
        fetch.setAttr(fetchToken, selector, labels, start, end)
        return fetch
    }

    fun fetch(token: String = "READ", selector: String, labels: Map<String, String> = HashMap(), start: FunctionElement, end: String = "-1", loadToken: Boolean = false, init: Fetch.() -> Unit = {}): Fetch {
        var fetchToken = "\'" + token + "\'"

        if (loadToken) {
            if (storedVariable.contains(token)) {
                fetchToken = "$" + token
            } else {
                throw WarpScriptDSLException("FETCH",fetchToken)
            }
        }

        val fetch = initTag(Fetch(), init)
        this.children.remove(start)
        fetch.setAttr(fetchToken, selector, labels, start, end)
        return fetch
    }

    //
    // Bucketize
    //

    fun bucketize(load: FunctionElement, bucketizer: String, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L, init: ListTag.() -> Unit = {}): ListTag {

        var internLoad = load.toString().removeSuffix("\n").removePrefix(" ")
        val bucketize = createBucketize(internLoad, bucketizer, lastBucket, bucketspan, bucketcount, init)
        this.children.remove(load)
        return bucketize
    }

    //
    // Bucketize
    //

    fun bucketize(load: ListTag, bucketizer: String, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L, init: ListTag.() -> Unit = {}): ListTag {

        var internLoad = load.toString().removeSuffix("\n").removePrefix(" ")
        val bucketize = createBucketize(internLoad, bucketizer, lastBucket, bucketspan, bucketcount, init)
        this.children.remove(load)
        return bucketize
    }

    fun bucketize(load: String = "SWAP", bucketizer: String, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L, init: ListTag.() -> Unit = {}): ListTag {
        var internLoad = "SWAP"
        if (load != "SWAP") {
            if (storedVariable.contains(load)) {
                internLoad = "$" + load
            } else {
                throw WarpScriptDSLException("BUCKETIZE", load)
            }
        }

        val bucketize = createBucketize(internLoad, bucketizer, lastBucket, bucketspan, bucketcount, init)
        return bucketize
    }

    private fun createBucketize(load: String, bucketizer: String, lastBucket: Long, bucketspan: Long, bucketcount: Long, init: ListTag.() -> Unit = {}): Bucketize {

        val bucketize = initTag(Bucketize("BUCKETIZE"), init)

        if (bucketspan == 0L && bucketcount == 0L ) {
            throw Exception("Inside BUCKETIZE framework, one of bucketspan or bucketcount must be different from zero")
        }

        bucketize.attributes.put(0, load)
        bucketize.attributes.put(1, bucketizer)
        bucketize.attributes.put(2, lastBucket.toString())
        bucketize.attributes.put(3, bucketspan.toString())
        bucketize.attributes.put(4, bucketcount.toString())
        return bucketize
    }

    //
    // Implement some single functions of the WarpScript language
    // Be aware
    // Warp 10 NULL = nullWarp
    // Warp 10 LOAD = loadWarp
    //

    fun now() = initTag(StandaloneFunction("NOW"), {})
    fun drop() = initTag(StandaloneFunction("DROP"), {})
    fun swap() = initTag(StandaloneFunction("SWAP"), {})
    fun stop() = initTag(StandaloneFunction("STOP"), {})
    fun clear() = initTag(StandaloneFunction("CLEAR"), {})
    fun sort() = initTag(StandaloneFunction("SORT"), {})
    fun nullWarp() = initTag(StandaloneFunction("NULL"), {})
    fun eval() = initTag(StandaloneFunction("EVAL"), {})
    fun evalSecure() = initTag(StandaloneFunction("EVALSecure"), {})
    fun snapshot() = initTag(StandaloneFunction("SNAPSHOT"), {})
    fun snapshotAll() = initTag(StandaloneFunction("SNAPSHOTALL"), {})
    fun loadWarp() = initTag(StandaloneFunction("LOAD"), {})
    fun run() = initTag(StandaloneFunction("RUN"), {})
    fun bootstrap() = initTag(StandaloneFunction("BOOTSTRAP"), {})
    fun mapStart() = initTag(StandaloneFunction("{"), {})
    fun mapeEnd() = initTag(StandaloneFunction("}"), {})
    fun listStart() = initTag(StandaloneFunction("["), {})
    fun listEnd() = initTag(StandaloneFunction("]"), {})
    fun toVector() = initTag(StandaloneFunction("->V"), {})
    fun toSet() = initTag(StandaloneFunction("->SET"), {})
    fun newgts() = initTag(StandaloneFunction("NEWGTS"), {})
    fun relabel() = initTag(StandaloneFunction("RELABEL"), {})
    fun rename() = initTag(StandaloneFunction("RENAME"), {})
    fun parseSelector() = initTag(StandaloneFunction("PARSESELCTOR"), {})


    //
    // Single Store function
    //

    //fun store(saved: String) = initTag(Store(saved), {})


    fun store(saved: String, init: Store.() -> Unit = {}): Store {
        if (!storedVariable.contains(saved)) {
            this.storedVariable.add(saved)
        }
        return initTag(Store(saved), init)
    }

    //
    // Single Load function
    //

    fun load(load: String, init: Load.() -> Unit = {}): Load {
        if (storedVariable.contains(load)) {
            return initTag(Load(load), init)
        } else {
            throw WarpScriptDSLException("load a variable", load)
        }
    }

    fun allowVariableName(authorizedVariable: List<String>) {
        this.storedVariable.addAll(authorizedVariable)
    }

    //
    // Single function to load a macro evaluation
    //

    fun evalMacro(macro: String, init: EvalMacro.() -> Unit = {}): EvalMacro {
        if (storedVariable.contains(macro)) {
            return initTag(EvalMacro(macro), init)
        } else {
            throw WarpScriptDSLException("the evaluate a macro", macro)
        }
    }

    //
    // Single Push function
    //

    fun push(data: String) = initTag(Push(data), {})

    //
    // Add WarpScript parameters function
    //

    //fun timeShift(delta: Long) = initTag(ParametersFunctions("TIMESHIFT", hashMapOf(0 to delta.toString())), {})
    fun timeShift(delta: Long, init: ParametersFunctions.() -> Unit = {}): ParametersFunctions {
        return initTag(ParametersFunctions("TIMESHIFT", hashMapOf(0 to delta.toString())), init)
    }

    fun timeShift(input: String, delta: Long, init: ParametersFunctions.() -> Unit = {}): ParametersFunctions {
        val load = "$" + input
        if (storedVariable.contains(input)) {
            return initTag(ParametersFunctions("TIMESHIFT", hashMapOf(0 to load.toString(), 1 to delta.toString())), init)
        } else {
            throw WarpScriptDSLException("TIMESHIFT", input)
        }
    }
}


