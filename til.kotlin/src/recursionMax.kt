fun main(args: Array<String>) {

    // listOf에 mutable prefix가 붙지 않았으면 기본적으로 immutable
    val list = listOf(1, 212, 523, 4, 325, 6, 100, 50, 23, 3231, 232, 25235, 1231, 521)
    require(getMaxValue(list) == 25235)

}

fun getMaxValue(list: List<Int>): Int = when {  // when절은 자바의 switch case와 동일함.
    list.isEmpty() -> throw NullPointerException()
    list.size == 1 -> list.first()
    else -> if(list.first() > getMaxValue(list.drop(1))){ //drop 1은 list의 끝에서 1개를 제거함
        list.first()
    } else { //switch case의 default
        getMaxValue(list.drop(1))
    }
}