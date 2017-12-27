package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

class Filter: Tag("") {

    //
    // All filter operators available on WarpScript
    //

    fun byclass(value: String): FilterFunction {
        return initTag(FilterFunction("filter.byclass", hashMapOf(1 to "\'$value\'")), {})
    }

    fun <String> bylabels(value: Map<String, String>): FilterFunction {
        return initTag(FilterFunction("filter.bylabels", hashMapOf(1 to this.getMapString(value))), {})
    }

    fun lastEq(value: Boolean): FilterFunction {
        return initTag(FilterFunction("filter.last.eq", hashMapOf(1 to value.toString())), {})
    }

    fun lastEq(value: Long): FilterFunction {
        return initTag(FilterFunction("filter.last.eq", hashMapOf(1 to value.toString())), {})
    }

    fun lastEq(value: Double): FilterFunction {
        return initTag(FilterFunction("filter.last.eq", hashMapOf(1 to value.toString())), {})
    }

    fun lastEq(value: String): FilterFunction {
        return initTag(FilterFunction("filter.last.eq", hashMapOf(1 to "\'$value\'")), {})
    }

    fun lastNe(value: Boolean): FilterFunction {
        return initTag(FilterFunction("filter.last.ne", hashMapOf(1 to value.toString())), {})
    }

    fun lastNe(value: Long): FilterFunction {
        return initTag(FilterFunction("filter.last.ne", hashMapOf(1 to value.toString())), {})
    }

    fun lastNe(value: Double): FilterFunction {
        return initTag(FilterFunction("filter.last.ne", hashMapOf(1 to value.toString())), {})
    }

    fun lastNe(value: String): FilterFunction {
        return initTag(FilterFunction("filter.last.ne", hashMapOf(0 to "\'$value\'")), {})
    }

    fun lastGt(value: Boolean): FilterFunction {
        return initTag(FilterFunction("filter.last.gt", hashMapOf(1 to value.toString())), {})
    }

    fun lastGt(value: Long): FilterFunction {
        return initTag(FilterFunction("filter.last.gt", hashMapOf(1 to value.toString())), {})
    }

    fun lastGt(value: Double): FilterFunction {
        return initTag(FilterFunction("filter.last.gt", hashMapOf(1 to value.toString())), {})
    }

    fun lastGt(value: String): FilterFunction {
        return initTag(FilterFunction("filter.last.gt", hashMapOf(0 to "\'$value\'")), {})
    }

    fun lastGe(value: Boolean): FilterFunction {
        return initTag(FilterFunction("filter.last.ge", hashMapOf(1 to value.toString())), {})
    }

    fun lastGe(value: Long): FilterFunction {
        return initTag(FilterFunction("filter.last.ge", hashMapOf(1 to value.toString())), {})
    }

    fun lastGe(value: Double): FilterFunction {
        return initTag(FilterFunction("filter.last.ge", hashMapOf(1 to value.toString())), {})
    }

    fun lastGe(value: String): FilterFunction {
        return initTag(FilterFunction("filter.last.ge", hashMapOf(0 to "\'$value\'")), {})
    }

    fun lastlt(value: Boolean): FilterFunction {
        return initTag(FilterFunction("filter.last.lt", hashMapOf(1 to value.toString())), {})
    }

    fun lastlt(value: Long): FilterFunction {
        return initTag(FilterFunction("filter.last.lt", hashMapOf(1 to value.toString())), {})
    }

    fun lastlt(value: Double): FilterFunction {
        return initTag(FilterFunction("filter.last.lt", hashMapOf(1 to value.toString())), {})
    }

    fun lastlt(value: String): FilterFunction {
        return initTag(FilterFunction("filter.last.lt", hashMapOf(0 to "\'$value\'")), {})
    }

    fun lastle(value: Boolean): FilterFunction {
        return initTag(FilterFunction("filter.last.le", hashMapOf(1 to value.toString())), {})
    }

    fun lastle(value: Long): FilterFunction {
        return initTag(FilterFunction("filter.last.le", hashMapOf(1 to value.toString())), {})
    }

    fun lastle(value: Double): FilterFunction {
        return initTag(FilterFunction("filter.last.le", hashMapOf(1 to value.toString())), {})
    }

    fun lastle(value: String): FilterFunction {
        return initTag(FilterFunction("filter.last.le", hashMapOf(0 to "\'$value\'")), {})
    }
}
