package tutorial.introduction

fun main() {
    // 특정 기능을 업그레이드 할 수 있음
    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "bye ") //times라고 명시하지않아도 *를 통해 함수 호출가능

    operator fun String.get(range: IntRange) = substring(range)
    val str = "항상 적을 용서하라"
    println(str[0..5])
}
