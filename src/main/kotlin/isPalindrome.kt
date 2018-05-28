fun isPalindrome(listOf: List<Int>): Boolean {
    return (0..listOf.size / 2).none {
        listOf[it] != listOf[listOf.lastIndex - it]
    }
}