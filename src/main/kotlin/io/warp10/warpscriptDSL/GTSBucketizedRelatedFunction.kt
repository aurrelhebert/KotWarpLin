package io.warp10.warpscriptDSL
 
// 
// WarpScript KOTLINDSL
// @author aurrelhebert 
// @license apache 2.0 
// 
 
// Autogenerated code
 
fun WarpScript.atBucket(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("ATBUCKET"), init) 
} 

fun WarpScript.atBucket(index: Long, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to index)
    return initTag(Functions("ATBUCKET", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.atBucket(index: Long? = null, indexElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to index)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to indexElements)
    return initTag(Functions("ATBUCKET", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.bucketCount(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("BUCKETCOUNT"), init) 
} 

fun WarpScript.bucketSpan(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("BUCKETSPAN"), init) 
} 

fun WarpScript.crop(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("CROP"), init) 
} 

fun WarpScript.fillNext(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("FILLNEXT"), init) 
} 

fun WarpScript.fillPrevious(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("FILLPREVIOUS"), init) 
} 

fun WarpScript.fillValue(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("FILLVALUE"), init) 
} 

fun WarpScript.fillValue(value: List<Any>, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to value)
    return initTag(Functions("FILLVALUE", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.fillValue(value: List<Any>? = null, valueElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to value)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to valueElements)
    return initTag(Functions("FILLVALUE", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.interpolate(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("INTERPOLATE"), init) 
} 

fun WarpScript.lastBucket(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("LASTBUCKET"), init) 
} 

fun WarpScript.stl(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("STL"), init) 
} 

fun WarpScript.stl(parameters: Map<String,Any>, init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to parameters)
    return initTag(Functions("STL", data, HashMap(), this, emptyLambda), init) 
} 

fun WarpScript.stl(parameters: Map<String,Any>? = null, parametersElements: Element.() -> Unit = emptyLambda, 
            init: Element.() -> Unit = {}) : Functions {
    val data = hashMapOf<Number, Any?>(1 to parameters)
    val elements = hashMapOf<Number, Element.() -> Unit>(1 to parametersElements)
    return initTag(Functions("STL", data, elements, this, emptyLambda), init) 
} 

fun WarpScript.unBucketize(init: Element.() -> Unit = {}) : Functions {
    return initTag(Functions("UNBUCKETIZE"), init) 
} 