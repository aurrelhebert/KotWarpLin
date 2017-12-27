package io.warp10.generator

class ParameterFunction(
        // WarpScript function name
        val warpScriptName: String,

        // Map position in Warp 10 stack, attribute name
        val attributes: HashMap<Number, String> = HashMap(),

        // Map attribute name, possible type
        val attributesType: HashMap<String, String> = HashMap()
)