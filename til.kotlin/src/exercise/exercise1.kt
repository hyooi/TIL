package exercise

import java.lang.NullPointerException

fun main(args: Array<String>) {
    val list = listOf(1, 212, 523, 4, 325, 6, 100, 50, 23, 3231, 232, 25235, 1231, 521)
    require(getMaxValue(list, list.first()) == 25235)

}

tailrec fun getMaxValue(list: List<Int>, acc: Int): Int =
    when {
        list.isEmpty() -> throw NullPointerException()
        list.size == 1 -> acc
        else -> if(list.first() >= acc) {
            getMaxValue(list.drop(1), list.first())
        } else {
            getMaxValue(list.drop(1), acc)
        }
    }