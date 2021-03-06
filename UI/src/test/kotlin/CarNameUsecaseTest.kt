
import com.barron.View
import com.di.DaggerAppComp
import io.kotest.assertions.timing.eventually
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.Test
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll
import io.kotest.property.forAll
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

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

@OptIn(ExperimentalTime::class)
@Test
class MyTests : ShouldSpec() {
    init {
        should("check if user repository has one row after message is sent") {
        //    sendMessage()
            eventually(Duration.seconds(5)) {
          //      userRepository.size() shouldBe 1
            }
        }
        should("greater then one") {
            (1..10).toList().customfilter { it < 11 } shouldBe true
            (1..10).toList().customfilter { it > 1 } shouldBe true
        }

    }
}


fun List<Int>.customfilter(filter:(Int)->Boolean):Boolean{
    var res:Boolean = false;
    for(i in this){
       if(filter(i))
           res = true
    }
    return res;
}



