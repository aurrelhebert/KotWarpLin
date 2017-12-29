package io.warp10.warpscriptDSL
 
// 
// WarpScript KOTLINDSL
// @author aurrelhebert 
// @license apache 2.0 
// 
 
// Autogenerated code
 
fun WarpScript.clone(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("CLONE"), init) 
} 

fun WarpScript.cloneEmpty(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("CLONEEMPTY"), init) 
} 

fun WarpScript.commonTicks(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("COMMONTICKS"), init) 
} 

fun WarpScript.compact(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("COMPACT"), init) 
} 

fun WarpScript.dedup(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("DEDUP"), init) 
} 

fun WarpScript.fillTicks(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("FILLTICKS"), init) 
} 

fun WarpScript.fillTicks(arg: List<Any>, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to arg)
    return initTag(Functions("FILLTICKS", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.fillTicks(arg: List<Any>? = null, argElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to arg)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to argElements)
    return initTag(Functions("FILLTICKS", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.integrate(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("INTEGRATE"), init) 
} 

fun WarpScript.integrate(initialValue: Double, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to initialValue)
    return initTag(Functions("INTEGRATE", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.integrate(initialValue: Double? = null, initialValueElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to initialValue)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to initialValueElements)
    return initTag(Functions("INTEGRATE", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.lastSort(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("LASTSORT"), init) 
} 

fun WarpScript.merge(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("MERGE"), init) 
} 

fun WarpScript.nonEmpty(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("NONEMPTY"), init) 
} 

fun WarpScript.partition(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("PARTITION"), init) 
} 

fun WarpScript.partition(labels: List<String>, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to labels)
    return initTag(Functions("PARTITION", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.partition(labels: List<String>? = null, labelsElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to labels)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to labelsElements)
    return initTag(Functions("PARTITION", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.quantize(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("QUANTIZE"), init) 
} 

fun WarpScript.quantize(values: List<Any>, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to values)
    return initTag(Functions("QUANTIZE", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.quantize(values: List<Any>? = null, valuesElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to values)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to valuesElements)
    return initTag(Functions("QUANTIZE", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.rSort(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("RSORT"), init) 
} 

fun WarpScript.rValueSort(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("RVALUESORT"), init) 
} 

fun WarpScript.rangeCompact(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("RANGECOMPACT"), init) 
} 

fun WarpScript.resets(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("RESETS"), init) 
} 

fun WarpScript.resets(counterType: Boolean, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to counterType)
    return initTag(Functions("RESETS", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.resets(counterType: Boolean? = null, counterTypeElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to counterType)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to counterTypeElements)
    return initTag(Functions("RESETS", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.sort(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("SORT"), init) 
} 

fun WarpScript.unWrap(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("UNWRAP"), init) 
} 

fun WarpScript.unWrap(wrapSeries: String, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to wrapSeries)
    return initTag(Functions("UNWRAP", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.unWrap(wrapSeries: String? = null, wrapSeriesElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to wrapSeries)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to wrapSeriesElements)
    return initTag(Functions("UNWRAP", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.valueDedup(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("VALUEDEDUP"), init) 
} 

fun WarpScript.valueDedup(age: Boolean, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to age)
    return initTag(Functions("VALUEDEDUP", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.valueDedup(age: Boolean? = null, ageElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to age)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to ageElements)
    return initTag(Functions("VALUEDEDUP", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.valueSort(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("VALUESORT"), init) 
} 

fun WarpScript.valueSplit(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("VALUESPLIT"), init) 
} 

fun WarpScript.valueSplit(split: String = "split-by-value", init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to split)
    return initTag(Functions("VALUESPLIT", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.valueSplit(split: String? = null, splitElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to split)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to splitElements)
    return initTag(Functions("VALUESPLIT", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.wrap(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("WRAP"), init) 
} 

fun WarpScript.wrapRaw(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("WRAPRAW"), init) 
} 