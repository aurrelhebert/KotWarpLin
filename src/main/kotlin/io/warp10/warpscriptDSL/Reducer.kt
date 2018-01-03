package io.warp10.warpscriptDSL


//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

class Reducer: Tag("") {

    //
    // All reducers operators available on WarpScript
    //

    fun argMax(value: Long): ReduceFunction {
        return initTag(ReduceFunction("reducer.argmax", hashMapOf(0 to value.toString())), {})
    }

    fun argMin(value: Long): ReduceFunction {
        return initTag(ReduceFunction("reducer.argmin", hashMapOf(0 to value.toString())), {})
    }

    fun count() = initTag(ReduceFunction("reducer.count"), {})

    fun countExcludeNulls() = initTag(ReduceFunction("reducer.count.exclude-nulls"), {})

    fun countIncludeNulls() = initTag(ReduceFunction("reducer.count.include-nulls"), {})

    fun join(value: String): ReduceFunction {
        return initTag(ReduceFunction("reducer.join", hashMapOf(0 to "\'$value\'")), {})
    }

    fun joinForbidNulls(value: String): ReduceFunction {
        return initTag(ReduceFunction("reducer.join.forbid-nulls", hashMapOf(0 to "\'$value\'")), {})
    }

    fun max() = initTag(ReduceFunction("reducer.max"), {})

    fun maxForbidNulls() = initTag(ReduceFunction("reducer.max.forbid-nulls"), {})

    fun mean() = initTag(ReduceFunction("reducer.mean"), {})

    fun meanExcludeNulls() = initTag(ReduceFunction("reducer.mean.exclude-nulls"), {})

    fun meanCircular(value: Number): ReduceFunction {
        return initTag(ReduceFunction("reducer.mean.circular", hashMapOf(0 to value.toString())), {})
    }

    fun meanCircularExcludeNulls(value: Number): ReduceFunction {
        return initTag(ReduceFunction("reducer.mean.circular.exclude-nulls", hashMapOf(0 to value.toString())), {})
    }

    fun median() = initTag(ReduceFunction("reducer.median"), {})

    fun min() = initTag(ReduceFunction("reducer.min"), {})

    fun minForbidNulls() = initTag(ReduceFunction("reducer.min.forbid-nulls"), {})

    fun and() = initTag(ReduceFunction("reducer.and"), {})

    fun andExcludeNulls() = initTag(ReduceFunction("reducer.and.exclude-nulls"), {})

    fun or() = initTag(ReduceFunction("reducer.or"), {})

    fun orExcludeNulls() = initTag(ReduceFunction("reducer.or.exclude-nulls"), {})

    fun sd(value: Boolean): ReduceFunction {
        return initTag(ReduceFunction("reducer.sd", hashMapOf(0 to value.toString())), {})
    }

    fun shannonentropy0() = initTag(ReduceFunction("reducer.shannonentropy.0"), {})

    fun shannonentropy1() = initTag(ReduceFunction("reducer.shannonentropy.1"), {})

    fun sum() = initTag(ReduceFunction("reducer.sum"), {})

    fun sumForbidNulls() = initTag(ReduceFunction("reducer.sum.forbid-nulls"), {})

    fun variance(value: Boolean): ReduceFunction {
        return initTag(ReduceFunction("reducer.var", hashMapOf(0 to value.toString())), {})
    }

}