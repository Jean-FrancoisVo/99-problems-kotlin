tailrec fun recIsPalindrome(listOf: List<Int>): Boolean =
        when {
            listOf.size <= 1 -> true
            listOf[0] != listOf[listOf.lastIndex] -> false
            else -> recIsPalindrome(listOf.subList(1, listOf.size - 1))
        }