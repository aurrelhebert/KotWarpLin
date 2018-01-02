package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

//
// Class to call when user want to push custom WarpScript elements on the stack
//

class Push : FunctionElement {

    // Variable to store name attribute --> always in first position
    var data: Any? = null

    override fun render(builder: StringBuilder, indent: String) {
        if (null != data) {
            builder.append("$indent")
            builder.append("${data.toString()} \n")
        }
    }

    constructor() : super("STORE")

    constructor(data: Any) : super("") {
        if (data is Number || data is String || data is Boolean) {
            this.data=data
        } else if (data is List<*>) {
            this.data=FunctionElement.getListString(data)
        } else if (data is Map<*,*>) {
            this.data=FunctionElement.getMapString(data)
        } else {
            throw Exception("Push expect native type: a Number, a String, a Boolean, a List<Any> or a Map<Any,Any> with natives types")
        }
    }
}