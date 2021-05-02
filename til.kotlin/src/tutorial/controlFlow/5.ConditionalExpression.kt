package tutorial.controlFlow

fun main() {
    // 3항연산자 대신 이런식으로 활용함
    fun max(a: Int, b: Int) = if(a>b) a else b
    println(max(99, -42))
}