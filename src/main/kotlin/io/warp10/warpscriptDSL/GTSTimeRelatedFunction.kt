package io.warp10.warpscriptDSL
 
// 
// WarpScript KOTLINDSL
// @author aurrelhebert 
// @license apache 2.0 
// 
 
// Autogenerated code
 
fun WarpScript.chunk(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("CHUNK"), init) 
} 

fun WarpScript.chunk(lastchunkend: Long, chunkwidth: Long, chunkoverlap: Long, chunkcount: Long, chunklabel: String, keepempty: Boolean = true, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to lastchunkend, 2 to chunkwidth, 3 to chunkoverlap, 4 to chunkcount, 5 to chunklabel, 6 to keepempty)
    return initTag(Functions("CHUNK", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.chunk(lastchunkend: Long? = null, lastchunkendElements: Element.() -> Unit = emptyLambda, 
            chunkwidth: Long? = null, chunkwidthElements: Element.() -> Unit = emptyLambda, 
            chunkoverlap: Long? = null, chunkoverlapElements: Element.() -> Unit = emptyLambda, 
            chunkcount: Long? = null, chunkcountElements: Element.() -> Unit = emptyLambda, 
            chunklabel: String? = null, chunklabelElements: Element.() -> Unit = emptyLambda, 
            keepempty: Boolean? = null, keepemptyElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to lastchunkend, 2 to chunkwidth, 3 to chunkoverlap, 4 to chunkcount, 5 to chunklabel, 6 to keepempty)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to lastchunkendElements, 2 to chunkwidthElements, 3 to chunkoverlapElements, 4 to chunkcountElements, 5 to chunklabelElements, 6 to keepemptyElements)
    return initTag(Functions("CHUNK", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.clip(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("CLIP"), init) 
} 

fun WarpScript.clip(limits: List<List<Long>>, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to limits)
    return initTag(Functions("CLIP", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.clip(limits: List<List<Long>>? = null, limitsElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to limits)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to limitsElements)
    return initTag(Functions("CLIP", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.shrink(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("SHRINK"), init) 
} 

fun WarpScript.shrink(size: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to size)
    return initTag(Functions("SHRINK", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.shrink(size: Long? = null, sizeElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to size)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to sizeElements)
    return initTag(Functions("SHRINK", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.timeClip(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("TIMECLIP"), init) 
} 

fun WarpScript.timeClip(originTimestamp: Long, duration: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to originTimestamp, 2 to duration)
    return initTag(Functions("TIMECLIP", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.timeClip(originTimestamp: Long? = null, originTimestampElements: Element.() -> Unit = emptyLambda, 
            duration: Long? = null, durationElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to originTimestamp, 2 to duration)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to originTimestampElements, 2 to durationElements)
    return initTag(Functions("TIMECLIP", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.timeModulo(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("TIMEMODULO"), init) 
} 

fun WarpScript.timeModulo(modulo: Long, label: String, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to modulo, 2 to label)
    return initTag(Functions("TIMEMODULO", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.timeModulo(modulo: Long? = null, moduloElements: Element.() -> Unit = emptyLambda, 
            label: String? = null, labelElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to modulo, 2 to label)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to moduloElements, 2 to labelElements)
    return initTag(Functions("TIMEMODULO", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.timeScale(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("TIMESCALE"), init) 
} 

fun WarpScript.timeScale(scalingFactor: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to scalingFactor)
    return initTag(Functions("TIMESCALE", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.timeScale(scalingFactor: Long? = null, scalingFactorElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to scalingFactor)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to scalingFactorElements)
    return initTag(Functions("TIMESCALE", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.timeShift(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("TIMESHIFT"), init) 
} 

fun WarpScript.timeShift(scalingFactor: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to scalingFactor)
    return initTag(Functions("TIMESHIFT", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.timeShift(scalingFactor: Long? = null, scalingFactorElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to scalingFactor)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to scalingFactorElements)
    return initTag(Functions("TIMESHIFT", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.timeSplit(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("TIMESPLIT"), init) 
} 

fun WarpScript.timeSplit(quietPeriod: Long, minValues: Long, label: String, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to quietPeriod, 2 to minValues, 3 to label)
    return initTag(Functions("TIMESPLIT", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.timeSplit(quietPeriod: Long? = null, quietPeriodElements: Element.() -> Unit = emptyLambda, 
            minValues: Long? = null, minValuesElements: Element.() -> Unit = emptyLambda, 
            label: String? = null, labelElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to quietPeriod, 2 to minValues, 3 to label)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to quietPeriodElements, 2 to minValuesElements, 3 to labelElements)
    return initTag(Functions("TIMESPLIT", data, elements, this, emptyLambda), init) 
} 