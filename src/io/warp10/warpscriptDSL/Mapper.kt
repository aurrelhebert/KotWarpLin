package io.warp10.warpscriptDSL

class Mapper: Tag("") {

    fun abs() = initTag(MapperFunction("mapper.abs"), {})

    fun add(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.add", hashMapOf(0 to value.toString())), {})
    }

    fun add(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.add", hashMapOf(0 to value.toString())), {})
    }

    fun mul(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.mul", hashMapOf(0 to value.toString())), {})
    }

    fun mul(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.mul", hashMapOf(0 to value.toString())), {})
    }

    fun ceil() = initTag(MapperFunction("mapper.ceil"), {})

    fun floor() = initTag(MapperFunction("mapper.floor"), {})

    fun toboolean() = initTag(MapperFunction("mapper.toboolean"), {})

    fun todouble() = initTag(MapperFunction("mapper.todouble"), {})

    fun parsedouble() = initTag(MapperFunction("mapper.parsedouble"), {})

    fun tolong() = initTag(MapperFunction("mapper.tolong"), {})

    fun tostring() = initTag(MapperFunction("mapper.tostring"), {})

    fun tick() = initTag(MapperFunction("mapper.tick"), {})

    fun year(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.year", hashMapOf(0 to "\'$value\'")), {})
    }

    fun month(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.month", hashMapOf(0 to "\'$value\'")), {})
    }

    fun weekday(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.weekday", hashMapOf(0 to "\'$value\'")), {})
    }

    fun hour(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.hour", hashMapOf(0 to "\'$value\'")), {})
    }

    fun minute(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.minute", hashMapOf(0 to "\'$value\'")), {})
    }

    fun second(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.second", hashMapOf(0 to "\'$value\'")), {})
    }

    fun exp(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.exp", hashMapOf(0 to value.toString())), {})
    }

    fun exp(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.exp", hashMapOf(0 to value.toString())), {})
    }

    fun log(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.log", hashMapOf(0 to value.toString())), {})
    }

    fun log(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.log", hashMapOf(0 to value.toString())), {})
    }

    fun pow(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.pow", hashMapOf(0 to value.toString())), {})
    }

    fun pow(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.pow", hashMapOf(0 to value.toString())), {})
    }

    fun tanh() = initTag(MapperFunction("mapper.tanh"), {})

    fun sigmoid() = initTag(MapperFunction("mapper.tanh"), {})

    fun sqrt() = initTag(MapperFunction("mapper.sqrt"), {})

    fun replace(value: Boolean): MapperFunction {
        return initTag(MapperFunction("mapper.replace", hashMapOf(0 to value.toString())), {})
    }

    fun replace(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.replace", hashMapOf(0 to value.toString())), {})
    }

    fun replace(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.replace", hashMapOf(0 to value.toString())), {})
    }

    fun replace(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.replace", hashMapOf(0 to "\'$value\'")), {})
    }

    fun eq(value: Boolean): MapperFunction {
        return initTag(MapperFunction("mapper.eq", hashMapOf(0 to value.toString())), {})
    }

    fun eq(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.eq", hashMapOf(0 to value.toString())), {})
    }

    fun eq(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.eq", hashMapOf(0 to value.toString())), {})
    }

    fun eq(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.eq", hashMapOf(0 to "\'$value\'")), {})
    }

    fun ne(value: Boolean): MapperFunction {
        return initTag(MapperFunction("mapper.ne", hashMapOf(0 to value.toString())), {})
    }

    fun ne(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.ne", hashMapOf(0 to value.toString())), {})
    }

    fun ne(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.ne", hashMapOf(0 to value.toString())), {})
    }

    fun ne(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.ne", hashMapOf(0 to "\'$value\'")), {})
    }

    fun gt(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.gt", hashMapOf(0 to value.toString())), {})
    }

    fun gt(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.gt", hashMapOf(0 to value.toString())), {})
    }

    fun gt(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.gt", hashMapOf(0 to "\'$value\'")), {})
    }

    fun ge(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.ge", hashMapOf(0 to value.toString())), {})
    }

    fun ge(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.ge", hashMapOf(0 to value.toString())), {})
    }

    fun ge(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.ge", hashMapOf(0 to "\'$value\'")), {})
    }

    fun lt(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.lt", hashMapOf(0 to value.toString())), {})
    }

    fun lt(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.lt", hashMapOf(0 to value.toString())), {})
    }

    fun lt(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.lt", hashMapOf(0 to "\'$value\'")), {})
    }

    fun le(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.le", hashMapOf(0 to value.toString())), {})
    }

    fun le(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.le", hashMapOf(0 to value.toString())), {})
    }

    fun le(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.le", hashMapOf(0 to "\'$value\'")), {})
    }

    fun highest() = initTag(MapperFunction("mapper.highest"), {})

    fun lowest() = initTag(MapperFunction("mapper.lowest"), {})

    fun max() = initTag(MapperFunction("mapper.max"), {})

    fun min() = initTag(MapperFunction("mapper.min"), {})

    fun delta() = initTag(MapperFunction("mapper.delta"), {})

    fun rate() = initTag(MapperFunction("mapper.rate"), {})

    fun first() = initTag(MapperFunction("mapper.first"), {})

    fun last() = initTag(MapperFunction("mapper.last"), {})

    fun sum() = initTag(MapperFunction("mapper.sum"), {})

    fun product() = initTag(MapperFunction("mapper.product"), {})

    fun mean() = initTag(MapperFunction("mapper.mean"), {})

    fun meanCircular(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.mean.circular", hashMapOf(0 to value.toString())), {})
    }

    fun meanCircular(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.mean.circular", hashMapOf(0 to value.toString())), {})
    }

    fun meanCirculatExcludeNulls(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.mean.circular.exclude-nulls", hashMapOf(0 to value.toString())), {})
    }

    fun meanCirculatExcludeNulls(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.mean.circular.exclude-nulls", hashMapOf(0 to value.toString())), {})
    }

    fun and() = initTag(MapperFunction("mapper.and"), {})

    fun or() = initTag(MapperFunction("mapper.or"), {})

    fun variance(value: Boolean): MapperFunction {
        return initTag(MapperFunction("mapper.var", hashMapOf(0 to value.toString())), {})
    }

    fun sd(value: Boolean): MapperFunction {
        return initTag(MapperFunction("mapper.sd", hashMapOf(0 to value.toString())), {})
    }

    fun hspeed() = initTag(MapperFunction("mapper.hspeed"), {})

    fun vspeed() = initTag(MapperFunction("mapper.vspeed"), {})

    fun hdist() = initTag(MapperFunction("mapper.hdist"), {})

    fun vdist() = initTag(MapperFunction("mapper.vdist"), {})

    fun count() = initTag(MapperFunction("mapper.count"), {})

    fun maxX(value: Boolean): MapperFunction {
        return initTag(MapperFunction("mapper.max.x", hashMapOf(0 to value.toString())), {})
    }

    fun maxX(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.max.x", hashMapOf(0 to value.toString())), {})
    }

    fun maxX(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.max.x", hashMapOf(0 to value.toString())), {})
    }

    fun maxX(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.max.x", hashMapOf(0 to "\'$value\'")), {})
    }

    fun minX(value: Boolean): MapperFunction {
        return initTag(MapperFunction("mapper.min.x", hashMapOf(0 to value.toString())), {})
    }

    fun minX(value: Long): MapperFunction {
        return initTag(MapperFunction("mapper.min.x", hashMapOf(0 to value.toString())), {})
    }

    fun minX(value: Double): MapperFunction {
        return initTag(MapperFunction("mapper.min.x", hashMapOf(0 to value.toString())), {})
    }

    fun minX(value: String): MapperFunction {
        return initTag(MapperFunction("mapper.min.x", hashMapOf(0 to "\'$value\'")), {})
    }
}