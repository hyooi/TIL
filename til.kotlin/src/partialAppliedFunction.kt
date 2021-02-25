fun main(args: Array<String>) {

    val func: (Int, Int) -> Int = { x, y -> x + y }
    println(func(5, 10))    // 15

    // 위와 같은 연산을 할 때, x만 먼저 알고 y는 언제 아는지 모르는 경우 부분 적용함수를 사용함
    val partial = func.partialAppliedFunction(5)

    // doSomething

    println(partial(10))    // 15

    val multiThree = { x: Int, y: Int, z: Int -> x * y * z }
    println(multiThree(1, 2, 3))    // 6

    val partial2 = multiThree.partialAppliedFunction(1)
    println(partial2(2, 3)) // 6

    val curriedMultiThree = multiThree.curried()
    println(curriedMultiThree(1)(2)(3)) // 6

    val p1 = curriedMultiThree(1)
    // doSomething
    val p2 = p1(2)
    // doSomething
    val p3 = p2(3)
    // doSomething
    println(p3) //6

}

// 무슨 타입이 될지 모를 때 partial applied function사용
// P1, P2 두 타입의 파라미터를 받아서 R타입을 반환하는 함수
fun <P1, P2, R> ((P1, P2) -> R).partialAppliedFunction(x: P1): (P2) -> R {
    return { p2 -> this(x, p2) }
}

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partialAppliedFunction(x: P1): (P2, P3) -> R {
    return { p2, P3 -> this(x, p2, P3) }
}

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R =
    { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } }