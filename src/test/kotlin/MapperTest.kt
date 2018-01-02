
import io.warp10.warpscriptDSL.Mapper
import io.warp10.warpscriptDSL.WarpScript
import org.junit.Test
import org.junit.Assert.*

class MapperTest {

    @Test
    fun minimalMap() {
        var tmp = WarpScript.generate {
            map(mapper = Mapper().max())
        }
        val output = "[ \n  SWAP \n  mapper.max \n  0 \n  0 \n  0 \n] \nMAP \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun mapperTestNativeElement() {
        var tmp = WarpScript.generate {
            map(mapper = Mapper().min(),pre =  1,post =  1,occurrences =  2)
        }
        val output = "[ \n  SWAP \n  mapper.min \n  1 \n  1 \n  2 \n] \nMAP \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun addMapLoadedVariable() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            map(loadElements = { load("test")}, mapper = Mapper().count(),pre =  1,post =  1,occurrences =  2)
        }
        val output = "[ \n  \$test \n  mapper.count \n  1 \n  1 \n  2 \n] \nMAP \n"
        assertEquals(output, tmp.toString())
    }


    @Test()
    fun onlyWarpScriptExceptMapper() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            map(loadElements = { load("test")}, mapper = Mapper().count(),preElements =  { push(0L) },
                    postElements =  { push(0L) },occurrencesElements =  { push(0L) })
        }
        val output = "[ \n  \$test \n  mapper.count \n  0 \n  0 \n  0 \n] \nMAP \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun chainMapperWarpScript() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            map(loadElements = {
                map(loadElements = {
                    map( loadElements = {load("test")}, mapper = Mapper().min(),pre =  1,post =  1,occurrences =  2)
                }, mapper = Mapper().add(2))
            }, mapper = Mapper().abs())
        }
        val output = StringBuilder()
        output.append("[ \n")
        output.append("  [ \n")
        output.append("    [ \n")
        output.append("      \$test \n")
        output.append("      mapper.min \n")
        output.append("      1 \n")
        output.append("      1 \n")
        output.append("      2 \n")
        output.append("    ] \n")
        output.append("    MAP \n")
        output.append("    2 mapper.add \n")
        output.append("    0 \n")
        output.append("    0 \n")
        output.append("    0 \n")
        output.append("  ] \n")
        output.append("  MAP \n")
        output.append("  mapper.abs \n")
        output.append("  0 \n")
        output.append("  0 \n")
        output.append("  0 \n")
        output.append("] \n")
        output.append("MAP \n")
        assertEquals(output.toString(), tmp.toString())
    }

    @Test(expected = Exception::class)
    fun failMissingMapper() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            map(loadElements = { load("test")},
                    preElements = { push(0L) },  postElements = { push(0L) },
                    occurrencesElements = { push(1L) })
        }
    }
}