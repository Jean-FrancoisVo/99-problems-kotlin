fun encodeDirect(list: List<Char>): List<Pair<Int, Char>> =
        list.fold(emptyList()) { acc, value ->
            if (acc.isEmpty()) {
                acc + Pair(1, value)
            } else {
                val last = acc.last()
                if (last.second == value) acc.dropLast(1) + Pair(last.first + 1, last.second)
                else acc + Pair(1, value)
            }
        }