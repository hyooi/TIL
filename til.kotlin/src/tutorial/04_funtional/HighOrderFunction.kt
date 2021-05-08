/*
* High Order Function(고차함수)
* 매개변수로 다른 함수를 가지거나 함수를 리턴하는 함수
*/
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 고차함수 선언
    return operation(x, y)
}

fun sum(x: Int, y: Int) = x + y

fun operation(): (Int) -> Int {
    return ::square //함수를 리턴
}

fun square(x: Int) = x*x

fun main() {
    //매개변수로 함수 가지기
    val sumResult = calculate(4, 5, ::sum) //::sum -> 함수 참조
    val mulResult = calculate(4, 5) { a, b -> a * b } // 인수로 람다 전달
    println("sumResult $sumResult, mulResult $mulResult")

    // 함수 리턴하기
    val func = operation()
    println(func(2))
}
