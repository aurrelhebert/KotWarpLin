package io.warp10.warpscriptDSL

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

class LOOP : FunctionElement {

    val bodyArray = arrayListOf<Element>()
    val stepArray = arrayListOf<Element>()

    override fun render(builder: StringBuilder, indent: String) {

        if (!attributes.isEmpty()) {
            builder.append(indent)
            for ((_, value) in attributes) {
                builder.append(" $value")
            }

            builder.append("\n")
        }


        if (!stepArray.isEmpty()) {

            builder.append("$indent <% \n")
            for (items in stepArray) {
                items.render(builder,indent + "  ")
            }
            builder.append(indent + " %> \n")
        }


        if (!bodyArray.isEmpty()) {

            builder.append("$indent <% \n")
            for (items in bodyArray) {
                items.render(builder,indent + "  ")
            }
            builder.append(indent + " %> \n")
        }

        builder.append(indent + " $name \n")
    }

    //
    // Function used to fill Loop body code with all the child element of current LOOP
    //

    fun applyBody(ws: WarpScript, entry: Element.() -> Unit) {
        this.bodyArray.addAll(this.getChilds(ws,entry))
    }

    //
    // Function used to fill step code with all the child element of current LOOP
    //

    fun applyStep(ws: WarpScript, entry: Element.() -> Unit) {
        this.stepArray.addAll(this.getChilds(ws,entry))
    }

    //
    // Constructor for LMAP and FOREACH
    //

    constructor(name: String) : super(name) {
    }

    //
    // Constructor for While
    //

    constructor(name: String, cond: Boolean) : super(name) {
        this.attributes.put(2, cond.toString())
    }


    //
    // Constructor for FOR and FORSTEP
    //

    constructor(name: String, start: Long, end: Long) : super(name) {
        this.attributes.put(0, start.toString())
        this.attributes.put(1, end.toString())
    }

    //
    // Case load body or step from Macro
    //

    constructor(name: String, body: String) : super(name) {
        this.attributes.put(3, body)
    }

    constructor(name: String, cond: Boolean, body: String) : super(name) {
        this.attributes.put(0, cond.toString())
        this.attributes.put(3, body)
    }

    constructor(name: String, start: Long, end: Long, body: String) : super(name) {
        this.attributes.put(0, start.toString())
        this.attributes.put(1, end.toString())
        this.attributes.put(3, body)
    }

    fun putAStepAttributes(step: String) {
        this.attributes.put(2, step)
    }
}