fun <T> pack(list: List<T>): List<List<T>> =
        if (list.isEmpty()) emptyList()
        else {
            val packed = list.takeWhile { it == list.first() }
            listOf(packed) + pack(list.drop(packed.size))
        }