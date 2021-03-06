package io.warp10.generator

//
// WarpScript KOTLINDSL
// @author aurrelhebert
// @license apache 2.0
//

import com.beust.klaxon.*
import java.io.File

//
// Class used to parse functions JSON resource file
//

class JSONParse {

    companion object {

        // Load resource file
        fun parseResourceFile(file: String, category: StringBuilder): HashMap<String, ParameterFunction> {

            val parser: Parser = Parser()
            val lineList = mutableListOf<String>()
            val stringBuilder = StringBuilder()
            File("resource/$file").useLines {
                lines -> lines.forEach { stringBuilder.append(it) }}

            // Initalize result map
            val returnMap = HashMap<String, ParameterFunction>()
            val json: JsonObject = parser.parse(stringBuilder) as JsonObject

            // Fill result map
            try {
                parseData(json, returnMap, category)
            } catch (e: Exception) {
                val message = e.message + " in file: $file"
                throw Exception(message)
            }
            //println(json)
            return returnMap
        }

        private fun parseData(json: JsonObject, jsonMap: HashMap<String, ParameterFunction>, category: StringBuilder) {

            if (!json.containsKey("data") || !json.containsKey("category")) {
                throw Exception("Expect json files to contains a category and a data key")
            }

            category.append(json.get("category") as String)
            // Load JSON data
            val data = json.get("data") as JsonArray<JsonObject>
            for (element in data) {

                // Verify if the main function keys exists
                if (!element.containsKey("function") || !element.containsKey("warpScriptName")) {
                    throw Exception ("Expect in JSON file a function name and it's WarpScriptName")
                }

                // Load current element data
                var javaName = element.get("function") as String
                var wsName = element.get("warpScriptName") as String

                // Create curent function
                val function = ParameterFunction(wsName)

                // Extract existing attributes from JSON file
                if (element.containsKey("attributes")) {
                    var attributesObject = element.get("attributes") as JsonArray<JsonObject>
                    for (paramObject in attributesObject) {

                        if ( !paramObject.containsKey("index") ||
                             !paramObject.containsKey("name") ||
                             !paramObject.containsKey("type")) {
                            throw Exception("Expect in JSON file for each attribute an index, name and type key")
                        }

                        // Extract param
                        val stackId = paramObject.get("index") as Int
                        val param = Param(paramObject.get("name") as String, paramObject.get("type") as String)

                        if (paramObject.containsKey("defaultValue")) {
                            param.defaultValue=paramObject.get("defaultValue") as String
                        }
                        // Add it to current function attribute
                        function.addAttribute(stackId, param)
                    }
                }

                // Add curent function to JSON map
                if (!javaName.equals("")) {
                    jsonMap.put(javaName, function)
                }
            }
        }
    }
}
