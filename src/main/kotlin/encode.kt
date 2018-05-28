fun <T> encode(value: List<T>): List<Pair<Int, T>> =
    pack(value).map {
        Pair(it.size, it.first())
    }