import org.junit.Test
import org.junit.Assert.*

import io.warp10.warpscriptDSL.WarpScript
import io.warp10.warpscriptDSL.add
import io.warp10.warpscriptDSL.pi
import io.warp10.warpscriptDSL.timeClip

class RandomGeneratedFunctionTesting {

    @Test
    fun warpScriptPi() {
        var tmp = WarpScript.generate {
            pi()
        }
        val output = StringBuilder()
        output.append("PI \n")
        assertEquals(output.toString(), tmp.toString())
    }

    @Test
    fun warpScriptAdd() {
        var tmp = WarpScript.generate {
            push(2)
            push(2)
            add()
            add(1)
            add(1, 2)
            add("test", "0")
            add(2.1, 0)
        }
        val output = StringBuilder()
        output.append("2 \n")
        output.append("2 \n")
        output.append("+ \n")
        output.append("  1 \n")
        output.append("+ \n")
        output.append("  1 \n")
        output.append("  2 \n")
        output.append("+ \n")
        output.append("  'test' \n")
        output.append("  '0' \n")
        output.append("+ \n")
        output.append("  2.1 \n")
        output.append("  0 \n")
        output.append("+ \n")
        assertEquals(output.toString(), tmp.toString())
    }

    @Test
    fun warpScriptTimeclip() {
        var tmp = WarpScript.generate {
            fetch(selector = "tmp")
            push("  100")
            timeClip()
            timeClip(100)
        }
        val output = StringBuilder()
        output.append("[ \n  \'READ\' \n  'tmp' \n  {} \n  NOW \n  -1 \n] \nFETCH \n")
        output.append("  100 \n")
        output.append("TIMECLIP \n")
        output.append("  100 \n")
        output.append("TIMECLIP \n")
        assertEquals(output.toString(), tmp.toString())
    }

}