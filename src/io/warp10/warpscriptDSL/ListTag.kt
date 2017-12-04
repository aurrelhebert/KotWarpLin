package io.warp10.warpscriptDSL

abstract class ListTag (name: String) : Tag(name) {

    override fun render(builder: StringBuilder, indent: String) {

        for (c in children) {
            c.render(builder,indent + "  ")
        }

        builder.append("$indent [ \n")

        for ((_,value) in attributes) {
            builder.append(indent + "   $value \n")
        }

        builder.append(" ] $name\n")
    }

}