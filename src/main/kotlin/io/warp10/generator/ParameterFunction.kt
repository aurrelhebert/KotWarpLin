package io.warp10.generator

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Output type of the JSON function file
// warpScriptName corresponds to the WarpScript name of a function
// attributes corresponds to it's attributes map with the number key corresponding to the parameter order on the stack
// and the param to the Param class associating a name to a Kotlin type
//

class ParameterFunction(


        // WarpScript function name
        val warpScriptName: String,

        // Map position in Warp 10 stack, attribute name
        val attributes: HashMap<Number, Param> = HashMap()
)
{
    fun addAttribute(index: Number, p: Param) {
        this.attributes.put(index,p)
    }

    override fun toString(): String {
        return "ParameterFunction(warpScriptName='$warpScriptName', attributes=$attributes)"
    }

}