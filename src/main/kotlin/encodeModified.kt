@Suppress("IMPLICIT_CAST_TO_ANY")
fun <T: Any> encodeModified(list: List<T>): List<Any> =
    pack(list).map {
        when (it.size) {
            1 -> it.first()
            else -> Pair(it.size, it.first())
        }
    }