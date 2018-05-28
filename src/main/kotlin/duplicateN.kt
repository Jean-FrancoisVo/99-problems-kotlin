fun duplicateN(n: Int, list: List<Char>): List<Char> =
        list.flatMap { value -> List(n, { value }) }