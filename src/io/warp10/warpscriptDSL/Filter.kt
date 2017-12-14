package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

class Filter: Tag("") {


    fun and() = initTag(BucketizerFunction("bucketizer.and"), {})
    fun count() = initTag(BucketizerFunction("bucketizer.count"), {})
    fun first() = initTag(BucketizerFunction("bucketizer.first"), {})

    fun byclass(value: String): MapperFunction {
        return initTag(MapperFunction("filter.byclass", hashMapOf(1 to "\'$value\'")), {})
    }

    fun <T> bylabels(value: Map<T, T>): MapperFunction {
        return initTag(MapperFunction("filter.bylabels", hashMapOf(1 to this.getMapString(value))), {})
    }

    fun lastEq(value: Boolean): MapperFunction {
        return initTag(MapperFunction("filter.last.eq", hashMapOf(1 to value.toString())), {})
    }

    fun lastEq(value: Long): MapperFunction {
        return initTag(MapperFunction("filter.last.eq", hashMapOf(1 to value.toString())), {})
    }

    fun lastEq(value: Double): MapperFunction {
        return initTag(MapperFunction("filter.last.eq", hashMapOf(1 to value.toString())), {})
    }

    fun lastEq(value: String): MapperFunction {
        return initTag(MapperFunction("filter.last.eq", hashMapOf(1 to "\'$value\'")), {})
    }

    fun lastNe(value: Boolean): MapperFunction {
        return initTag(MapperFunction("filter.last.ne", hashMapOf(1 to value.toString())), {})
    }

    fun lastNe(value: Long): MapperFunction {
        return initTag(MapperFunction("filter.last.ne", hashMapOf(1 to value.toString())), {})
    }

    fun lastNe(value: Double): MapperFunction {
        return initTag(MapperFunction("filter.last.ne", hashMapOf(1 to value.toString())), {})
    }

    fun lastNe(value: String): MapperFunction {
        return initTag(MapperFunction("filter.last.ne", hashMapOf(0 to "\'$value\'")), {})
    }

    fun lastGt(value: Boolean): MapperFunction {
        return initTag(MapperFunction("filter.last.gt", hashMapOf(1 to value.toString())), {})
    }

    fun lastGt(value: Long): MapperFunction {
        return initTag(MapperFunction("filter.last.gt", hashMapOf(1 to value.toString())), {})
    }

    fun lastGt(value: Double): MapperFunction {
        return initTag(MapperFunction("filter.last.gt", hashMapOf(1 to value.toString())), {})
    }

    fun lastGt(value: String): MapperFunction {
        return initTag(MapperFunction("filter.last.gt", hashMapOf(0 to "\'$value\'")), {})
    }

    fun lastGe(value: Boolean): MapperFunction {
        return initTag(MapperFunction("filter.last.ge", hashMapOf(1 to value.toString())), {})
    }

    fun lastGe(value: Long): MapperFunction {
        return initTag(MapperFunction("filter.last.ge", hashMapOf(1 to value.toString())), {})
    }

    fun lastGe(value: Double): MapperFunction {
        return initTag(MapperFunction("filter.last.ge", hashMapOf(1 to value.toString())), {})
    }

    fun lastGe(value: String): MapperFunction {
        return initTag(MapperFunction("filter.last.ge", hashMapOf(0 to "\'$value\'")), {})
    }

    fun lastlt(value: Boolean): MapperFunction {
        return initTag(MapperFunction("filter.last.lt", hashMapOf(1 to value.toString())), {})
    }

    fun lastlt(value: Long): MapperFunction {
        return initTag(MapperFunction("filter.last.lt", hashMapOf(1 to value.toString())), {})
    }

    fun lastlt(value: Double): MapperFunction {
        return initTag(MapperFunction("filter.last.lt", hashMapOf(1 to value.toString())), {})
    }

    fun lastlt(value: String): MapperFunction {
        return initTag(MapperFunction("filter.last.lt", hashMapOf(0 to "\'$value\'")), {})
    }

    fun lastle(value: Boolean): MapperFunction {
        return initTag(MapperFunction("filter.last.le", hashMapOf(1 to value.toString())), {})
    }

    fun lastle(value: Long): MapperFunction {
        return initTag(MapperFunction("filter.last.le", hashMapOf(1 to value.toString())), {})
    }

    fun lastle(value: Double): MapperFunction {
        return initTag(MapperFunction("filter.last.le", hashMapOf(1 to value.toString())), {})
    }

    fun lastle(value: String): MapperFunction {
        return initTag(MapperFunction("filter.last.le", hashMapOf(0 to "\'$value\'")), {})
    }
}
