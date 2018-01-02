
import io.warp10.warpscriptDSL.Bucketizer
import io.warp10.warpscriptDSL.WarpScript
import org.junit.Test
import org.junit.Assert.*

class BucketizeTest {

    @Test
    fun minimalBucketize() {
        var tmp = WarpScript.generate {
            bucketize(bucketizer = Bucketizer().max(), bucketspan = 1600)
        }
        val output = "[ \n  SWAP \n  bucketizer.max \n  0 \n  1600 \n  0 \n] \nBUCKETIZE \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun bucketizeTestNativeElement() {
        var tmp = WarpScript.generate {
            bucketize(bucketizer = Bucketizer().max(),lastBucket =  0L,bucketspan =  0L,bucketcount =  1)
        }
        val output = "[ \n  SWAP \n  bucketizer.max \n  0 \n  0 \n  1 \n] \nBUCKETIZE \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun addBucketizeLoadedVariable() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            bucketize(loadElements = { load("test")}, bucketizer = Bucketizer().max(),lastBucket =  0L,bucketspan =  0L,bucketcount =  1)
        }
        val output = "[ \n  \$test \n  bucketizer.max \n  0 \n  0 \n  1 \n] \nBUCKETIZE \n"
        assertEquals(output, tmp.toString())
    }

    @Test()
    fun onlyWarpScriptExceptBucketizer() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            bucketize(loadElements = { load("test")}, bucketizer = Bucketizer().max(),
                    lastBucketElements = { push(0L) },  bucketspanElements = { push(0L) },
                    bucketcountElements = { push(1L) })
        }
        val output = "[ \n  \$test \n  bucketizer.max \n  0 \n  0 \n  1 \n] \nBUCKETIZE \n"
        assertEquals(output, tmp.toString())
    }

    @Test
    fun chainBucketizeWarpScript() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            bucketize(loadElements =
                {
                    bucketize(loadElements =
                    {
                        load("test")
                    }, bucketizer = Bucketizer().min(), bucketcount = 1L)
                }, bucketizer = Bucketizer().count(), bucketcount = 1L)
        }
        val output = "[ \n  [ \n    \$test \n    bucketizer.min \n    0 \n    0 \n    1 \n  ] \n  BUCKETIZE \n  bucketizer.count \n  0 \n  0 \n  1 \n] \nBUCKETIZE \n"
        assertEquals(output, tmp.toString())
    }

    @Test(expected = Exception::class)
    fun failBucketizeNativeCondition() {
        var tmp = WarpScript.generate {
            bucketize("TOKEN", Bucketizer().max(), 0L, 0L, 0L)
        }
    }

    @Test(expected = Exception::class)
    fun failMissingBucketizer() {
        var tmp = WarpScript.generate {
            allowVariableName(listOf("test"))
            bucketize(loadElements = { load("test")},
                    lastBucketElements = { push(0L) },  bucketspanElements = { push(0L) },
                    bucketcountElements = { push(1L) })
        }
    }
}