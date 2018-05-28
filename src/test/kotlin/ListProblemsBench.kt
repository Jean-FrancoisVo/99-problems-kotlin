import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import kotlin.system.measureNanoTime

class ListProblemsBench : StringSpec({

    "palindrome" {
        val values = List(10000000, { 1 })
        println(measureNanoTime {
            val palindrome = isPalindromeBench(values)
            palindrome.shouldBe(true)
        })
    }

    "rec palindrome" {
        val values = List(10000000, { 1 })
        println(measureNanoTime {
            val palindrome = recIsPalindromeBench(values)
            palindrome.shouldBe(true)
        })
    }


})

tailrec fun recIsPalindromeBench(listOf: List<Int>) : Boolean =
    if (listOf.size <= 1) true
    else if (listOf[0] != listOf[listOf.lastIndex]) false
    else recIsPalindromeBench(listOf.subList(1, listOf.size - 1))


fun isPalindromeBench(listOf: List<Int>) : Boolean {
    return (0..listOf.size / 2).none {
        listOf[it] != listOf[listOf.lastIndex - it]
    }
}
