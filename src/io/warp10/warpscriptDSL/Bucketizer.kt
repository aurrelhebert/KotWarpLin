package io.warp10.warpscriptDSL

class Bucketizer: Tag("") {

    fun and() = initTag(BucketizerFunction("bucketizer.and"), {})
    fun count() = initTag(BucketizerFunction("bucketizer.count"), {})
    fun first() = initTag(BucketizerFunction("bucketizer.first"), {})
    fun join() = initTag(BucketizerFunction("bucketizer.join"), {})
    fun last() = initTag(BucketizerFunction("bucketizer.last"), {})
    fun max() = initTag(BucketizerFunction("bucketizer.max"), {})
    fun mean() = initTag(BucketizerFunction("bucketizer.mean"), {})
    fun meanCircular() = initTag(BucketizerFunction("bucketizer.mean.circular"), {})
    fun meanCircularExcludeNulls() = initTag(BucketizerFunction("bucketizer.mean.circular.exclude-nulls"), {})
    fun median() = initTag(BucketizerFunction("bucketizer.median"), {})
    fun min() = initTag(BucketizerFunction("bucketizer.min"), {})
    fun or() = initTag(BucketizerFunction("bucketizer.or"), {})
    fun sum() = initTag(BucketizerFunction("bucketizer.sum"), {})

}

