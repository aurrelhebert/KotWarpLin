package io.warp10.warpscriptDSL

class Bucketizer: Tag("") {

    fun and() = initTag(BucketizerFunction("bucketizer.and"), {})
    fun count() = initTag(BucketizerFunction("bucketizer.count"), {})
    fun first() = initTag(BucketizerFunction("bucketizer.first"), {})

    fun join(value: String): MapperFunction {
        return initTag(MapperFunction("bucketizer.mean.circular", hashMapOf(0 to "\'$value\'")), {})
    }

    fun last() = initTag(BucketizerFunction("bucketizer.last"), {})
    fun max() = initTag(BucketizerFunction("bucketizer.max"), {})
    fun mean() = initTag(BucketizerFunction("bucketizer.mean"), {})

    fun meanCircular(value: Long): MapperFunction {
        return initTag(MapperFunction("bucketizer.mean.circular", hashMapOf(0 to value.toString())), {})
    }

    fun meanCircular(value: Double): MapperFunction {
        return initTag(MapperFunction("bucketizer.mean.circular", hashMapOf(0 to value.toString())), {})
    }

    fun meanCircularExcludeNulls(value: Long): MapperFunction {
        return initTag(MapperFunction("bucketizer.mean.circular.exclude-nulls", hashMapOf(0 to value.toString())), {})
    }

    fun meanCircularExcludeNulls(value: Double): MapperFunction {
        return initTag(MapperFunction("bucketizer.mean.circular.exclude-nulls", hashMapOf(0 to value.toString())), {})
    }

    fun median() = initTag(BucketizerFunction("bucketizer.median"), {})
    fun min() = initTag(BucketizerFunction("bucketizer.min"), {})
    fun or() = initTag(BucketizerFunction("bucketizer.or"), {})
    fun sum() = initTag(BucketizerFunction("bucketizer.sum"), {})

}

