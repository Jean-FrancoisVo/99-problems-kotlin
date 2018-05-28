fun drop(n: Int, list: List<Char>) =
        list.filterIndexed { index, _ ->
            (index + 1) % n != 0
        }