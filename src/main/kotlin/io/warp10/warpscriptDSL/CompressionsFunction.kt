package io.warp10.warpscriptDSL
 
// 
// WarpScript KOTLINDSL
// @author aurrelhebert 
// @license apache 2.0 
// 
 
// Autogenerated code
 
fun WarpScript.gzip(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("GZIP"), init) 
} 

fun WarpScript.gzip(input: String, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to input)
    return initTag(Functions("GZIP", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.gzip(input: String? = null, inputElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to input)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to inputElements)
    return initTag(Functions("GZIP", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.toZOrderCurve(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("->Z"), init) 
} 

fun WarpScript.toZOrderCurve(parameter: List<Long>, bitwidth: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to parameter, 2 to bitwidth)
    return initTag(Functions("->Z", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.toZOrderCurve(parameter: List<Long>? = null, parameterElements: Element.() -> Unit = emptyLambda, 
            bitwidth: Long? = null, bitwidthElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to parameter, 2 to bitwidth)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to parameterElements, 2 to bitwidthElements)
    return initTag(Functions("->Z", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.unGzip(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("UNGZIP"), init) 
} 

fun WarpScript.zOrderCurveTo(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("Z->"), init) 
} 

fun WarpScript.zOrderCurveTo(numberOfComponents: Long, bitWidth: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to numberOfComponents, 2 to bitWidth)
    return initTag(Functions("Z->", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.zOrderCurveTo(numberOfComponents: Long? = null, numberOfComponentsElements: Element.() -> Unit = emptyLambda, 
            bitWidth: Long? = null, bitWidthElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to numberOfComponents, 2 to bitWidth)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to numberOfComponentsElements, 2 to bitWidthElements)
    return initTag(Functions("Z->", data, elements, this, emptyLambda), init) 
} 