fun compress(list: List<Char>) =
        list.filterIndexed { index, _ ->
            if (list.lastIndex != index) list[index] != list[index + 1] else true
        }

fun compressFold(list: List<Char>) =
        list.fold(emptyList<Char>()) { result, value ->
            if (result.isNotEmpty() && result.last() == value) result
            else result + value
        }