package io.warp10.warpscriptDSL
 
// 
// WarpScript KOTLINDSL
// @author aurrelhebert 
// @license apache 2.0 
// 
 
// Autogenerated code
 
fun WarpScript.IsoNormalize(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("ISONORMALIZE"), init) 
} 

fun WarpScript.cProb(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("CPROB"), init) 
} 

fun WarpScript.cProb(separator: String, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to separator)
    return initTag(Functions("CPROB", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.cProb(separator: String? = null, separatorElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to separator)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to separatorElements)
    return initTag(Functions("CPROB", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.correlate(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("CORRELATE"), init) 
} 

fun WarpScript.lowess(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("LOWESS"), init) 
} 

fun WarpScript.lowess(bandwidth: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to bandwidth)
    return initTag(Functions("LOWESS", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.lowess(bandwidth: Long? = null, bandwidthElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to bandwidth)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to bandwidthElements)
    return initTag(Functions("LOWESS", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.lttb(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("LTTB"), init) 
} 

fun WarpScript.lttb(threshold: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to threshold)
    return initTag(Functions("LTTB", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.lttb(threshold: Long? = null, thresholdElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to threshold)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to thresholdElements)
    return initTag(Functions("LTTB", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.mode(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("MODE"), init) 
} 

fun WarpScript.monotonic(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("MONOTONIC"), init) 
} 

fun WarpScript.monotonic(decreasing: Boolean = true, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to decreasing)
    return initTag(Functions("MONOTONIC", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.monotonic(decreasing: Boolean? = null, decreasingElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to decreasing)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to decreasingElements)
    return initTag(Functions("MONOTONIC", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.musigma(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("MUSIGMA"), init) 
} 

fun WarpScript.musigma(besselCorrection: Boolean = true, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to besselCorrection)
    return initTag(Functions("MUSIGMA", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.musigma(besselCorrection: Boolean? = null, besselCorrectionElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to besselCorrection)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to besselCorrectionElements)
    return initTag(Functions("MUSIGMA", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.nSumSumSq(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("NSUMSUMSQ"), init) 
} 

fun WarpScript.normalize(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("NORMALIZE"), init) 
} 

fun WarpScript.prob(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("PROB"), init) 
} 

fun WarpScript.rLowess(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("RLOWESS"), init) 
} 

fun WarpScript.rLowess(q: Long, r: Long, d: Long, p: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to q, 2 to r, 3 to d, 4 to p)
    return initTag(Functions("RLOWESS", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.rLowess(q: Long? = null, qElements: Element.() -> Unit = emptyLambda, 
            r: Long? = null, rElements: Element.() -> Unit = emptyLambda, 
            d: Long? = null, dElements: Element.() -> Unit = emptyLambda, 
            p: Long? = null, pElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to q, 2 to r, 3 to d, 4 to p)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to qElements, 2 to rElements, 3 to dElements, 4 to pElements)
    return initTag(Functions("RLOWESS", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.singleExponentialSmoothing(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("SINGLEEXPONENTIALSMOOTHING"), init) 
} 

fun WarpScript.singleExponentialSmoothing(alpha: Number, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to alpha)
    return initTag(Functions("SINGLEEXPONENTIALSMOOTHING", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.singleExponentialSmoothing(alpha: Number? = null, alphaElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to alpha)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to alphaElements)
    return initTag(Functions("SINGLEEXPONENTIALSMOOTHING", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.standardize(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("STANDARDIZE"), init) 
} 

fun WarpScript.tlttb(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("TLTTB"), init) 
} 

fun WarpScript.tlttb(threshold: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to threshold)
    return initTag(Functions("TLTTB", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.tlttb(threshold: Long? = null, thresholdElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to threshold)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to thresholdElements)
    return initTag(Functions("TLTTB", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.valueHistogram(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("VALUEHISTOGRAM"), init) 
} 