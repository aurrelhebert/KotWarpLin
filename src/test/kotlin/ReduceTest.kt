import io.warp10.warpscriptDSL.*
import org.junit.Test
import org.junit.Assert.*

class ReduceTest {

    @Test
    fun minimalReduce() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            reduce(loadElements = { load("test")
                load("test")}, reducer = Reducer().sum())
        }
        val output = "[ \n  \$test \n  \$test \n  [] \n  reducer.sum \n] \nREDUCE \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun reduceTestNativeElement() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            reduce(loadElements = { load("test")
                load("test")}, labels = listOf("test"), reducer = Reducer().sum())
        }
        val output = "[ \n  \$test \n  \$test \n  [ \'test\' ] \n  reducer.sum \n] \nREDUCE \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun onlyWarpScriptExceptOp() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            reduce(loadElements = { load("test")
                load("test")}, labelsElements = { emptyList() }, reducer = Reducer().sum())
        }
        val output = "[ \n  \$test \n  \$test \n  [] \n  reducer.sum \n] \nREDUCE \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun chainReduceWarpScript() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            reduce(loadElements = {
                reduce(loadElements = { load("test")
                    load("test")}, labelsElements = {
                    emptyList()
                    addToExistingList(p2="label")
                }, reducer = Reducer().sum())
            }, reducer = Reducer().min())
        }
        val output = StringBuilder()
        output.append("[ \n")
        output.append("  [ \n")
        output.append("    \$test \n")
        output.append("    \$test \n")
        output.append("    [] \n")
        output.append("      \'label\' \n")
        output.append("    +! \n")
        output.append("    reducer.sum \n")
        output.append("  ] \n")
        output.append("  REDUCE \n")
        output.append("  [] \n")
        output.append("  reducer.min \n")
        output.append("] \n")
        output.append("REDUCE \n")
        assertEquals(output.toString(), tmp.toString())
    }

    @Test(expected = Exception::class)
    fun failMissingReducer() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            reduce(loadElements = { load("test")
                load("test")}, labelsElements = { emptyList() })
        }
    }
}