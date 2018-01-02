
import io.warp10.warpscriptDSL.Mapper
import io.warp10.warpscriptDSL.Filter
import io.warp10.warpscriptDSL.WarpScript
import io.warp10.warpscriptDSL.emptyList
import org.junit.Test
import org.junit.Assert.*

class FilterTest {

    @Test
    fun minimalFilter() {
        var tmp = WarpScript.generate {
            filter(filterFun = Filter().byclass("name"))
        }
        val output = "[ \n  SWAP \n  [] \n  \'name\' filter.byclass \n] \nFILTER \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun filterTestNativeElement() {
        var tmp = WarpScript.generate {
            filter(labels = listOf("label"), filterFun = Filter().bylabels(hashMapOf("label" to "42")))
        }
        val output = "[ \n  SWAP \n  [ \'label\' ] \n  { 'label' '42' } filter.bylabels \n] \nFILTER \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun addFilterLoadedVariable() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            filter(loadElements = { load("test")}, labels = listOf("label"),filterFun = Filter().bylabels(hashMapOf("label" to "42")))
        }
        val output = "[ \n  \$test \n  [ \'label\' ] \n  { 'label' '42' } filter.bylabels \n] \nFILTER \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun onlyWarpScriptExceptFilter() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            filter(loadElements = { load("test")}, labelsElements = { emptyList() },filterFun =  Filter().bylabels(hashMapOf("label" to "42")))
        }
        val output =  "[ \n  \$test \n  [] \n  { 'label' '42' } filter.bylabels \n] \nFILTER \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun chainFilterWarpScript() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            filter( loadElements= {
                filter (
                loadElements = { load("test")},
                    labelsElements = { emptyList() },filterFun =  Filter().bylabels(hashMapOf("label" to "42")))
            }, filterFun = Filter().bylabels(hashMapOf("label" to "42")))
        }
        val output = StringBuilder()
        output.append("[ \n")
        output.append("  [ \n")
        output.append("    \$test \n")
        output.append("    [] \n")
        output.append("    { 'label' '42' } filter.bylabels \n")
        output.append("  ] \n")
        output.append("  FILTER \n")
        output.append("  [] \n")
        output.append("  { 'label' '42' } filter.bylabels \n")
        output.append("] \n")
        output.append("FILTER \n")
        assertEquals(output.toString(), tmp.toString())
    }

    @Test(expected = Exception::class)
    fun failMissingFilter() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            filter(loadElements = { load("test")},
                    labelsElements = { emptyList() })
        }
    }
}