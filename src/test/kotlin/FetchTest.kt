
import io.warp10.warpscriptDSL.*
import org.junit.Test
import org.junit.Assert.*

class FetchTest {

    @Test
    fun minimalFetch() {
        var tmp = WarpScript.generate {
            fetch(selector = "tmp")
        }
        val output = "[ \n  \'READ\' \n  'tmp' \n  {} \n  NOW \n  -1 \n] \nFETCH \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun fetchTestNativeElement() {
        val token = "MYTOKEN"
        var tmp = WarpScript.generate {
            fetch(token = token, selector = "tmp", labels = HashMap<String,String>(), start = 150000L, end = 15000)
        }
        val output = "[ \n  \'$token\' \n  'tmp' \n  {} \n  150000 \n  15000 \n] \nFETCH \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun onlyWarpScriptExceptBucketizer() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("token"))
            fetch(tokenElements = { load("token")}, selectorElements = { push("\'tmp\'") },
                    labelsElements = { push(hashMapOf<String,String>("label" to "42")) },  startElements = { now()},
                    endElements = { now() })
        }
        val output = "[ \n  \$token \n  'tmp' \n  { \'label\' \'42\' } \n  NOW \n  NOW \n] \nFETCH \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun chainFetchWarpScript() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("token"))
            fetch(tokenElements = { load("token")},
                    selectorElements = {
                        push( "<% DROP %>")
                        run()
                        name {
                            fetch(tokenElements = { load("token") },
                                    selector = "read")
                            get(0)
                        }
                    },
                    labelsElements = { push(hashMapOf<String,String>("label" to "42")) },  startElements = { now()},
                    endElements = { now() })
        }
        val output = StringBuilder()
        output.append("[ \n")
        output.append("  \$token \n")
        output.append("  [ \n")
        output.append("    \$token \n")
        output.append("    \'read\' \n")
        output.append("    {} \n")
        output.append("    NOW \n")
        output.append("    -1 \n")
        output.append("  ] \n")
        output.append("  FETCH \n")
        output.append("    0 \n")
        output.append("  GET \n")
        output.append("  NAME \n")
        output.append("  { \'label\' \'42\' } \n")
        output.append("  NOW \n")
        output.append("  NOW \n")
        output.append("] \n")
        output.append("FETCH \n")
        assertEquals(output.toString(), tmp.toString())
    }

    @Test(expected = Exception::class)
    fun failMissingFetchSelector() {
        var tmp = WarpScript.generate {
            fetch(token = "tmp")
        }
    }
}