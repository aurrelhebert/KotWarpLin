package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

class Apply: Tag("") {

    //
    // All apply operators available on WarpScript
    //

    fun add() = initTag(ApplyFunction("op.add"), {})

    fun and() = initTag(ApplyFunction("op.and"), {})

    fun div() = initTag(ApplyFunction("op.div"), {})

    fun eq() = initTag(ApplyFunction("op.eq"), {})

    fun ge() = initTag(ApplyFunction("op.ge"), {})

    fun gt() = initTag(ApplyFunction("op.gt"), {})

    fun le() = initTag(ApplyFunction("op.le"), {})

    fun lt() = initTag(ApplyFunction("op.lt"), {})

    fun mask() = initTag(ApplyFunction("op.mask"), {})

    fun negmask() = initTag(ApplyFunction("op.negmask"), {})

    fun mul() = initTag(ApplyFunction("op.mul"), {})

    fun ne() = initTag(ApplyFunction("op.ne"), {})

    fun or() = initTag(ApplyFunction("op.or"), {})

    fun sub() = initTag(ApplyFunction("op.sub"), {})
}