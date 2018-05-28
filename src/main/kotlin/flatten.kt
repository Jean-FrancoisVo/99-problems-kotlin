@Suppress("UNCHECKED_CAST")
fun flatten(list: List<Any>): List<Any> {
    return list.flatMap {
        if (it is List<*>) flatten(it as List<Any>) else listOf(it)
    }
}