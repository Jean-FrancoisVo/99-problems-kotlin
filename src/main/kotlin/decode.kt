fun decode(list: List<Pair<Int, Char>>): List<Char> =
        list.flatMap { List(it.first, { _ -> it.second}) }