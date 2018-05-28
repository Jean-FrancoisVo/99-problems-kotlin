fun duplicate(list: List<Char>) =
    list.fold(emptyList<Char>()) { acc, value ->
        acc + value + value
    }