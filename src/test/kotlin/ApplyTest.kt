
import io.warp10.warpscriptDSL.Apply
import io.warp10.warpscriptDSL.Mapper
import io.warp10.warpscriptDSL.WarpScript
import org.junit.Test
import org.junit.Assert.*

class ApplyTest {

    @Test
    fun minimalApply() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            apply(entry = { load("test")
                load("test")}, op = Apply().add())
        }
        val output = "[ \n  SWAP \n  mapper.max \n  0 \n  0 \n  0 \n] \nMAP \n"
        assertEquals(output, tmp.toString())
    }
}