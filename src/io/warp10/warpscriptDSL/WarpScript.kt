package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

import kotlin.collections.HashMap
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType
import kotlin.reflect.jvm.reflect

//
// Kotlin WarpScript Lib
//

class WarpScript(name: String) : Tag(name) {

    var storedVariable = ArrayList<String>()

    val emptyLambda: Element.() -> Unit = {}

    //
    // Fetch framework
    //

    fun fetch(token: String = "READ", selector: String, labels: Map<String, String> = HashMap(), start: Any = "_NOW", end: Any = -1, init: ListType.() -> Unit = {}): ListType {
        val fetch = initTag(ListType(
                "FETCH",
                Fetch.getNativeFetchParameters(token,selector,labels,start,end),
                HashMap(),
                this,
                emptyLambda
        ), init)
        return fetch
    }

    fun fetch(token: String = "READ", tokenElements: Element.() -> Unit = emptyLambda,
              selector: String = "_NONE", selectorElements: Element.() -> Unit = emptyLambda,
              labels: HashMap<String, String> = HashMap(), labelsElements: Element.() -> Unit = emptyLambda,
              start: Any = "_NOW", startElements: Element.() -> Unit = emptyLambda,
              end: Any = -1, endElements: Element.() -> Unit = emptyLambda, init: ListType.() -> Unit = {}): ListType {

        Fetch.verifyFetch(selector, selectorElements, emptyLambda)
        val fetch = initTag(ListType("FETCH",
                Fetch.getNativeFetchParameters(token,selector,labels,start,end),
                Fetch.getElementsFetchParameters(tokenElements,selectorElements,labelsElements,startElements,endElements), this, emptyLambda), init)
        return fetch
    }

    fun fetch(parameters: Element.() -> Unit = emptyLambda, init: ListType.() -> Unit = {}): ListType {

        var fetch = initTag(ListType("FETCH"), init)
        if (parameters != emptyLambda) {
            fetch = initTag(ListType("FETCH",
                    HashMap<Number,Any>(),
                    hashMapOf(0 to parameters),
                    this,
                    emptyLambda
            ), init)
        }

        return fetch
    }

    //
    // Bucketize framework
    //

    fun bucketize(load: String = "SWAP", bucketizer: BucketizerFunction, lastBucket: Long = 0L, bucketspan: Long = 0L, bucketcount: Long = 0L, init: ListType.() -> Unit = {}): ListType {
        Bucketize.verifyBucketizeNative(bucketspan, bucketcount)
        val bucketize = initTag(ListType(
                    "BUCKETIZE",
                    Bucketize.getNativeBucketizeParameters(load,bucketizer,lastBucket,bucketspan,bucketcount),
                    HashMap(),
                    this,
                    emptyLambda
            ), init)
        return bucketize
    }

    fun bucketize(load: String = "SWAP", loadElements: Element.() -> Unit = emptyLambda,
                  bucketizer: BucketizerFunction? = null, bucketizerElements: Element.() -> Unit = emptyLambda,
                  lastBucket: Long = 0L, lastBucketElements: Element.() -> Unit = emptyLambda,
                  bucketspan: Long = 0L, bucketspanElements: Element.() -> Unit = emptyLambda,
                  bucketcount: Long = 0L, bucketcountElements: Element.() -> Unit = emptyLambda, init: ListType.() -> Unit = {}): ListType {

        Bucketize.verifyBucketize(bucketizer, bucketizerElements, emptyLambda)
        val bucketize = initTag(ListType(
                    "BUCKETIZE",
                    Bucketize.getNativeBucketizeParameters(load,bucketizer,lastBucket,bucketspan,bucketcount),
                    Bucketize.getElementBucketizeParameters(loadElements,bucketizerElements,lastBucketElements,bucketspanElements,bucketcountElements),
                    this,
                    emptyLambda
            ), init)
        return bucketize
    }

    fun bucketize(parameters: Element.() -> Unit = emptyLambda, init: ListType.() -> Unit = {}): ListType {

        var bucketize = initTag(ListType("BUCKETIZE"), init)
        if (parameters != emptyLambda) {
            bucketize = initTag(ListType("BUCKETIZE",
                    HashMap<Number,Any>(),
                    hashMapOf(0 to parameters),
                    this,
                    emptyLambda
            ), init)
        }

        return bucketize
    }

    //
    // Map framework
    //

    fun map(load: String = "SWAP", mapper: MapperFunction, pre: Long = 0L, post: Long = 0L, occurrences: Long = 0L, init: ListType.() -> Unit = {}): ListType {
        val mapper = initTag(ListType(
                "MAP",
                MapFw.getNativeMapParameters(load,mapper,pre,post,occurrences),
                HashMap(),
                this,
                emptyLambda
        ), init)
        return mapper
    }

    fun map(load: String = "SWAP", loadElements: Element.() -> Unit = emptyLambda,
                  mapper: MapperFunction? = null, mapperElements: Element.() -> Unit = emptyLambda,
                  pre: Long = 0L, preElements: Element.() -> Unit = emptyLambda,
                  post: Long = 0L, postElements: Element.() -> Unit = emptyLambda,
                  occurrences: Long = 0L, occurrencesElements: Element.() -> Unit = emptyLambda, init: ListType.() -> Unit = {}): ListType {

        MapFw.verifyMapper(mapper, mapperElements, emptyLambda)
        val mapper = initTag(ListType(
                "MAP",
                MapFw.getNativeMapParameters(load,mapper,pre,post,occurrences),
                MapFw.getElementMapParameters(loadElements,mapperElements,preElements,postElements,occurrencesElements),
                this,
                emptyLambda
        ), init)
        return mapper
    }

    fun map(parameters: Element.() -> Unit = emptyLambda, init: ListType.() -> Unit = {}): ListType {

        var mapper = initTag(ListType("MAP"), init)
        if (parameters != emptyLambda) {
            mapper = initTag(ListType("MAP",
                    HashMap<Number,Any>(),
                    hashMapOf(0 to parameters),
                    this,
                    emptyLambda
            ), init)
        }

        return mapper
    }

    //
    // Filter framework
    //

    fun filter(load: String = "SWAP", labels: List<Any>, filterFun: FilterFunction, init: ListType.() -> Unit = {}): ListType {
        val filter = initTag(ListType(
                "FILTER",
                FilterFw.getNativeFilterParameters(load,labels,filterFun),
                HashMap(),
                this,
                emptyLambda
        ), init)
        return filter
    }

    fun filter(load: String = "SWAP", loadElements: Element.() -> Unit = emptyLambda,
               labels: List<Any> = ArrayList<Any>(), labelsElements: Element.() -> Unit = emptyLambda,
               filterFun: FilterFunction? = null, filterFunElements: Element.() -> Unit = emptyLambda, init: ListType.() -> Unit = {}): ListType {

        FilterFw.verifyFilter(filterFun, filterFunElements, emptyLambda)
        val filter = initTag(ListType(
                "FILTER",
                FilterFw.getNativeFilterParameters(load,labels,filterFun),
                FilterFw.getElementFilterParameters(loadElements,labelsElements,filterFunElements),
                this,
                emptyLambda
        ), init)
        return filter
    }

    fun filter(parameters: Element.() -> Unit = emptyLambda, init: ListType.() -> Unit = {}): ListType {

        var filter = initTag(ListType("FILTER"), init)
        if (parameters != emptyLambda) {
            filter = initTag(ListType("FILTER",
                    HashMap<Number,Any>(),
                    hashMapOf(0 to parameters),
                    this,
                    emptyLambda
            ), init)
        }

        return filter
    }

    //
    // Apply framework
    //

    fun <T> apply(entry: Element.() -> Unit,labels: List<T>, op: ApplyFunction, init: ListTag.() -> Unit = {}): ApplyFw<T> {

        val filter = initTag(ApplyFw(labels, op), init)
        filter.applyLoader(this, entry)
        return filter
    }

    //
    // If then function
    //

    fun ifThen(cond: Boolean, thenTab: Element.() -> Unit, init: Element.() -> Unit = {}): IF {

        val ifThen = initTag(IF("IFT", cond), init)
        ifThen.applyThen(this, thenTab)
        return ifThen
    }

    //
    // If then function
    //
    fun ifThen(cond: Element.() -> Unit, thenTab: Element.() -> Unit, init: Element.() -> Unit = {}): IF {

        val ifThen = initTag(IF("IFT"), init)
        ifThen.applyThen(this, thenTab)
        ifThen.applyCond(this, cond)
        return ifThen
    }


    //
    // If then Else function
    //

    fun ifThenElse(cond: Boolean, thenTab: Element.() -> Unit, elseTab : Element.() -> Unit, init: Element.() -> Unit = {}): IF {

        val ifThen = initTag(IF("IFTE", cond), init)
        ifThen.applyThen(this, thenTab)
        ifThen.applyElse(this, elseTab)
        return ifThen
    }

    //
    // If then Else function
    //

    fun ifThenElse(cond: Element.() -> Unit, thenTab: Element.() -> Unit, elseTab : Element.() -> Unit, init: Element.() -> Unit = {}): IF {

        val ifThen = initTag(IF("IFTE"), init)
        ifThen.applyThen(this, thenTab)
        ifThen.applyCond(this, cond)
        ifThen.applyElse(this, elseTab)
        return ifThen
    }

    //
    // LOOP functions
    //

    //
    // FOREACH
    //

    fun foreach(bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        val foreach = initTag(LOOP("FOREACH"), init)
        foreach.applyBody(this, bodyTab)
        return foreach
    }

    fun foreach(body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("FOR", body)
        }

        return initTag(LOOP("FOREACH", "$" + body), init)
    }

    //
    // FOREACH
    //

    fun lmap(bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        val foreach = initTag(LOOP("LMAP"), init)
        foreach.applyBody(this, bodyTab)
        return foreach
    }

    fun lmap(body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("LMAP", body)
        }
        return initTag(LOOP("LMAP", "$" + body), init)
    }

    //
    // Warp 10 FOR
    //

    fun forW(start: Long, end: Long, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        val foreach = initTag(LOOP("FOR", start, end), init)
        foreach.applyBody(this, bodyTab)
        return foreach
    }

    fun forW(start: Long, end: Long, body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("FOR", body)
        }
        return initTag(LOOP("FOR", start, end, "$" + body), init)

    }

    //
    // FORSTEP
    //

    fun forStep(start: Long, end: Long, stepTab: Element.() -> Unit, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        val foreach = initTag(LOOP("FORSTEP", start, end), init)
        foreach.applyBody(this, bodyTab)
        foreach.applyStep(this, stepTab)
        return foreach
    }

    fun forStep(start: Long, end: Long, step: String, body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(step)) {
            throw WarpScriptDSLException("FORSTEP", step)
        }

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("FORSTEP", body)
        }
        val foreach = initTag(LOOP("FORSTEP", start, end, "$" + body), init)
        foreach.putAStepAttributes("$" + step)
        return foreach
    }

    fun forStep(start: Long, end: Long, step: String, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(step)) {
            throw WarpScriptDSLException("FORSTEP", step)
        }

        val foreach = initTag(LOOP("FORSTEP", start, end), init)
        foreach.applyBody(this, bodyTab)
        foreach.putAStepAttributes("$" + step)
        return foreach
    }

    fun forStep(start: Long, end: Long, stepTab: Element.() -> Unit, body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("FORSTEP", body)
        }

        val foreach = initTag(LOOP("FORSTEP", start, end,"$" + body), init)
        foreach.applyStep(this, stepTab)
        return foreach
    }

    //
    // While
    //

    fun whileW(cond: Boolean, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        val whileW = initTag(LOOP("WHILE", cond), init)
        whileW.applyBody(this, bodyTab)
        return whileW
    }

    fun whileW(cond: Element.() -> Unit, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        val whileW = initTag(LOOP("WHILE"), init)
        whileW.applyBody(this, bodyTab)
        whileW.applyStep(this, cond)
        return whileW
    }

    fun whileW(cond: Boolean, body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("WHILE", body)
        }
        return initTag(LOOP("WHILE", cond, "$" + body), init)
    }

    fun whileW(cond: Element.() -> Unit, body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("WHILE", body)
        }
        val whileW = initTag(LOOP("WHILE", "$" + body), init)
        whileW.applyStep(this, cond)
        return whileW
    }

    fun whileW(cond: String, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(cond)) {
            throw WarpScriptDSLException("WHILE", cond)
        }

        val whileW = initTag(LOOP("WHILE"), init)
        whileW.applyBody(this, bodyTab)
        whileW.putAStepAttributes("$" + cond)
        return whileW
    }

    fun whileW(cond: String, body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("WHILE", body)
        }

        if (!this.storedVariable.contains(cond)) {
            throw WarpScriptDSLException("WHILE", cond)
        }

        val whileW = initTag(LOOP("WHILE", "$" + body), init)
        whileW.putAStepAttributes("$" + cond)
        return whileW
    }

    //
    // Until
    //

    fun until(cond: Boolean, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        val whileW = initTag(LOOP("UNTIL", cond), init)
        whileW.applyBody(this, bodyTab)
        return whileW
    }

    fun until(cond: Element.() -> Unit, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        val whileW = initTag(LOOP("UNTIL"), init)
        whileW.applyBody(this, bodyTab)
        whileW.applyStep(this, cond)
        return whileW
    }

    fun until(cond: Boolean, body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("UNTIL", body)
        }
        return initTag(LOOP("UNTIL", cond, "$" + body), init)
    }

    fun until(cond: Element.() -> Unit, body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("UNTIL", body)
        }
        val whileW = initTag(LOOP("UNTIL", "$" + body), init)
        whileW.applyStep(this, cond)
        return whileW
    }

    fun until(cond: String, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(cond)) {
            throw WarpScriptDSLException("UNTIL", cond)
        }

        val whileW = initTag(LOOP("UNTIL"), init)
        whileW.applyBody(this, bodyTab)
        whileW.putAStepAttributes("$" + cond)
        return whileW
    }

    fun until(cond: String, body: String, init: Element.() -> Unit = {}): LOOP {

        if (!this.storedVariable.contains(body)) {
            throw WarpScriptDSLException("UNTIL", body)
        }

        if (!this.storedVariable.contains(cond)) {
            throw WarpScriptDSLException("UNTIL", cond)
        }

        val whileW = initTag(LOOP("UNTIL", "$" + body), init)
        whileW.putAStepAttributes("$" + cond)
        return whileW
    }

    //
    // Define macro
    //

    fun macro(bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): Macro {
        val macro = initTag(Macro(), init)
        macro.applyBody(this, bodyTab)
        return macro
    }

    //
    // Define macro
    //

    fun macro(name: String, bodyTab: Element.() -> Unit, init: Element.() -> Unit = {}): Macro {
        val macro = initTag(Macro(), init)
        macro.applyBody(this, bodyTab)
        this.store(name)
        return macro
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
    fun parseSelector() = initTag(StandaloneFunction("PARSESELECTOR"), {})

    //
    // Single Store function
    //

    fun store(saved: String, init: Store.() -> Unit = {}): Store {
        if (!storedVariable.contains(saved)) {
            this.storedVariable.add(saved)
        }
        return initTag(Store(saved), init)
    }

    //
    // Single Load function (custom function added for KotlinDSL, corresponds to $varName in WarpScript)
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
    // Single function to load a macro evaluation (custom function added for KotlinDSL,
    // corresponds to @varName in WarpScript)
    //

    fun evalMacro(macro: String, init: EvalMacro.() -> Unit = {}): EvalMacro {
        if (storedVariable.contains(macro)) {
            return initTag(EvalMacro(macro), init)
        } else {
            throw WarpScriptDSLException("the evaluate a macro", macro)
        }
    }

    //
    // Single Push function (custom function add for KotlinDSL allowing the user to push it's CUSTOM WarpScript code)
    //

    fun push(data: String) = initTag(Push(data), {})

    fun <T>push(data: List<T>) = initTag(Push(this.getListString(data)), {})

    fun <T, U>push(data: Map<T, U>) = initTag(Push(this.getMapString(data)), {})

    //
    // Add WarpScript parameters function
    //
    fun timeShift(init: ParametersFunctions.() -> Unit = {}): ParametersFunctions {
        return initTag(ParametersFunctions("TIMESHIFT"), init)
    }

    fun timeShift (delta: Long, init: ParametersFunctions.() -> Unit = {}): ParametersFunctions {
        val timeShift = initTag(ParametersFunctions("TIMESHIFT"), init)
        timeShift.setelements(hashMapOf<Number,Any>(0 to delta))
        return timeShift
    }

    fun timeShift(delta: Element.() -> Unit, init: ParametersFunctions.() -> Unit = {}): ParametersFunctions {
        var deltaElements = ArrayList<Element>()
        var timeShift = initTag(ParametersFunctions("TIMESHIFT"), init)

        deltaElements.addAll(timeShift.getChilds(this,delta))
        timeShift.setAttributesElements(1,deltaElements)
        return timeShift
    }
}


