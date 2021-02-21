fun main(args: Array<String>) {

    val list = listOf(1, 2, 3, 4, 5)

    println(unSimple(list)) //[20, 40]
    println(simple(list))   //[20, 40]

}

fun unSimple(list: List<Int>): List<Int> {
    val evens = mutableListOf<Int>()
    for (elem in list) {
        if (elem % 2 == 0) {
            evens.add(elem)
        }
    }
    val result = mutableListOf<Int>()
    for (elem in evens) {
        result.add(elem * 10)
    }
    return result
}

fun simple(list: List<Int>): List<Int> = list
    .filter { it % 2 == 0 }
    .map { it * 10 }