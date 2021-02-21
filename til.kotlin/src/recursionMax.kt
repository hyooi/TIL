fun main(args: Array<String>) {

    val list = listOf(1, 212, 523, 4, 325, 6, 100, 50, 23, 3231, 232, 25235, 1231, 521)

    require(getMaxValue(list) == 25235)

}

fun getMaxValue(list: List<Int>): Int = when {
    list.isEmpty() -> throw NullPointerException()
    list.size == 1 -> list.first()
    else -> if(list.first() > getMaxValue(list.drop(1))){
        list.first()
    } else {
        getMaxValue(list.drop(1))
    }
}