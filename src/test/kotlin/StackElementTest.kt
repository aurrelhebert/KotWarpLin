
import io.warp10.warpscriptDSL.WarpScript
import io.warp10.warpscriptDSL.drop
import io.warp10.warpscriptDSL.now
import io.warp10.warpscriptDSL.swap
import org.junit.Test
import org.junit.Assert.*

class StackElementTest {

    @Test
    fun storeElement() {
        var tmp = WarpScript.generate {
            store("test")
        }
        val output = "  \'test\' \nSTORE \n"
        assertEquals(output, tmp.toString())
    }

    @Test(expected = Exception::class)
    fun failLoad() {
        var tmp = WarpScript.generate {
            load("test")
        }
    }

    @Test
    fun storeAndLoadElement() {
        var tmp = WarpScript.generate {
            store("test")
            load("test")
        }
        val output = "  \'test\' \nSTORE \n\$test \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun swapTest() {
        var tmp = WarpScript.generate {
            swap()
        }
        val output = "SWAP \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun dropTest() {
        var tmp = WarpScript.generate {
            drop()
        }
        val output = "DROP \n"
        assertEquals(output, tmp.toString())
    }


    @Test
    fun nowTest() {
        var tmp = WarpScript.generate {
            now()
        }
        val output = "NOW \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun functionalWarp() {
        var tmp = WarpScript.generate {
            store("test")
            swap({
                now()
                load("test")
            })
        }
        val output = "  \'test\' \nSTORE \nNOW \n\$test \nSWAP \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun pushTest() {
        var tmp = WarpScript.generate {
            push(2)
            push(0L)
            push("2 \'test\' STORE")
            push(true)
            push(listOf(1, 2, 3))
            push(ArrayList<Int>())
            push(hashMapOf("0" to  1.0, 1 to "42"))
        }
        val output = StringBuilder()
        output.append("2 \n")
        output.append("0 \n")
        output.append("2 \'test\' STORE \n")
        output.append("true \n")
        output.append("[ 1 2 3 ] \n")
        output.append("[] \n")
        output.append("{ \'0\' 1.0 1 \'42\' } \n")
        assertEquals(output.toString(), tmp.toString())
    }
}