import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldEqual
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.specs.StringSpec

class ListProblems : StringSpec({
    "P01: last element from list" {
        val last = last(listOf(1, 1, 2, 3, 5, 8))
        last.shouldBe(8)
    }

    "P01: last element from empty list" {
        shouldThrow<NoSuchElementException> {
            last(listOf())
        }
    }

    "P02: penultimate element from list" {
        val penultimate = penultimate(listOf(1, 1, 2, 3, 5, 8))
        penultimate.shouldBe(5)
    }

    "P02: penultimate element from empty list" {
        shouldThrow<IndexOutOfBoundsException> {
            penultimate(listOf())
        }
    }

    "P03: find nth element" {
        val nth = nth(2, listOf(1, 1, 2, 3, 5, 8))
        nth.shouldBe(2)
    }

    "P04: find the number of elements of a list" {
        val length = length(listOf(1, 1, 2, 3, 5, 8))
        length.shouldBe(6)
    }

    "P05: reverse list" {
        val reversed = reverse(listOf(1, 1, 2, 3, 5, 8))
        reversed.shouldBe(listOf(8, 5, 3, 2, 1, 1))
    }

    "P05: reverse list of size 1" {
        val reversed = reverse(listOf(1))
        reversed.shouldBe(listOf(1))
    }

    "P05: reverse empty list" {
        val reversed = reverse(listOf())
        reversed.shouldBe(listOf<Int>())
    }

    "P06: palindrome" {
        val palindrome = isPalindrome(listOf(1, 2, 3, 2, 1))
        palindrome.shouldBe(true)
    }

    "P06: rec palindrome" {
        val palindrome = recIsPalindrome(listOf(1, 2, 3, 2, 1))
        palindrome.shouldBe(true)
    }

    "P06: palindrome of size 4" {
        val palindrome = isPalindrome(listOf(1, 2, 2, 1))
        palindrome.shouldBe(true)
    }

    "P06: not a palindrome" {
        val palindrome = isPalindrome(listOf(1, 1, 3, 2, 1))
        palindrome.shouldBe(false)
    }

    "P07: flatten list one flat element" {
        val result = flatten(listOf(1, 2, 3))
        result.shouldBe(listOf(1, 2, 3))
    }

    "P06: flatten list one flat element" {
        val result = flatten(listOf(listOf(1)))
        result.shouldBe(listOf(1))
    }

    "P07: flatten list" {
        val result = flatten(listOf(listOf(1, 1), 2, listOf(3, listOf(5, 8))))
        result.shouldBe(listOf(1, 1, 2, 3, 5, 8))
    }

    "P08: compress" {
        val result = compress("aaaabccaadeeee".toList())
        result.shouldEqual(listOf('a', 'b', 'c', 'a', 'd', 'e'))
    }

    "P08: compress" {
        val result = compress("aaaabccaadeeed".toList())
        result.shouldEqual(listOf('a', 'b', 'c', 'a', 'd', 'e', 'd'))
    }

    "P08: empty compress" {
        compress("".toList()).shouldBe("".toList())
    }

    "P09: pack" {
        pack("aaaabccaadeeee".toList())
                .shouldBe(listOf(listOf('a', 'a', 'a', 'a'), listOf('b'), listOf('c', 'c'), listOf('a', 'a'), listOf('d'), listOf('e', 'e', 'e', 'e')))
    }

    "P10: list encoding" {
        encode("aaaabccaadeeee".toList())
                .shouldBe(listOf(Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')))
    }

    "P11: list encoding modified" {
        encodeModified("aaaabccaadeeee".toList())
                .shouldBe(listOf(Pair(4, 'a'), 'b', Pair(2, 'c'), Pair(2, 'a'), 'd', Pair(4, 'e')))
    }

    "P12: list decode" {
        decode(listOf(Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')))
                .shouldBe(listOf('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    }

    "P13: encode direct" {
        encodeDirect("aaaabccaadeeee".toList())
                .shouldBe(listOf(Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')))
    }

    "P14: duplicate elements in list" {
        duplicate("abccd".toList())
                .shouldBe(listOf('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd'))
    }

    "P15: duplicate n elements in list" {
        duplicateN(3, "abccd".toList())
                .shouldBe(listOf('a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd'))
    }

    "P16: drop every n elements in list" {
        drop(3, "abcdefghijk".toList())
                .shouldBe(listOf('a', 'b', 'd', 'e', 'g', 'h', 'j', 'k'))
    }
})

