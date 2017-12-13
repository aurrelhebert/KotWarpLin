package io.warp10.warpscriptDSL

//
// Function builder
//
abstract class FunctionElement(val name: String) : Element {

    //
    // Function parameters
    //

    val attributes = hashMapOf<Number, String>()
    val loader = arrayListOf<Element>()

    //
    // Build render for a WS function:
    //   param0
    //   param1
    //   FUNCTION
    //

    override fun render(builder: StringBuilder, indent: String) {

        for ((_,value) in attributes) {
            builder.append(indent + " $value")
        }

        builder.append(indent + " $name \n")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }

}