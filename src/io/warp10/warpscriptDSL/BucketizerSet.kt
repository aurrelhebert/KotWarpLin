package io.warp10.warpscriptDSL

enum class Bucketizer(val value: String) {
    AND("bucketizer.and"),
    COUNT("bucketizer.count"),
    FIRST("bucketizer.first"),
    JOIN("bucketizer.join"),
    LAST("bucketizer.last"),
    MAX("bucketizer.max"),
    MEAN("bucketizer.mean"),
    MEAN_CIRCULAR("bucketizer.mean.circular"),
    MEAN_CIRCULAR_EXLUDING_NULLS("bucketizer.mean.circular.exclude-nulls"),
    MEDIAN("bucketizer.median"),
    MIN("bucketizer.min"),
    OR("bucketizer.or"),
    SUM("bucketizer.sum")
}
