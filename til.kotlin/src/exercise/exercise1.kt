package exercise

fun main(args: Array<String>) {

    val list = listOf(1, 212, 523, 4, 325, 6, 100, 50, 23, 3231, 232, 25235, 1231, 521)

    require(getMaxValue(list, list.first()) == 25235)

}

tailrec fun getMaxValue(list: List<Int>, acc: Int): Int {
    TODO()
}