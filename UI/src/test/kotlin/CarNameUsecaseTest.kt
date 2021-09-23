
import com.View
import com.di.DaggerAppComp
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.Test
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.property.checkAll
import io.kotest.property.forAll

@Test
class CarNameUsecaseTest: StringSpec({
    "valid Car names" {
        val v = View()
        DaggerAppComp.create().inject(v)

        forAll<String, String> { a, b ->
            v.dcf.setCar(a).subscribe()
            print("$a ?==? $b")
            a == v.dcf.getCar().blockingGet().name
        }
    }
    "a many iterations test" {
        checkAll<Double, Double>(10_000) { a, b ->
            a.dec() == b.inc()
        }
    }
})
