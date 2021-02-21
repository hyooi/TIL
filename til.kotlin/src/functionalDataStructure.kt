fun main(args: Array<String>) {

    val value = 3
    val result = plusThree(value)

    println(result) // 6
    println(value)  // 3

    val list = listOf(1, 2)
    val listResult = plusThree(list)

    println(list)
    println(listResult)

    fun <T> List<T>.tail() : List<T> = this.drop(1)

    val tail = listResult.tail()
}

fun plusThree(x: Int): Int {
    return x + 3
}

fun plusThree(list: List<Int>): List<Int> {
    return list.plus(3)
}