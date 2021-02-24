fun main(args: Array<String>) {
    println(factorial(10))  // 3628800
    println(factorial2(10)) // 3628800
    println(factorial3(10)) // 3628800
}

fun factorial(num: Int): Int {
    var result = 1
    for (i in 1..num) {
        result *= i
    }

    return result
}

fun factorial2(num: Int): Int = when (num) {
    1 -> 1
    else -> num * factorial2(num - 1)
}


/*
 - tailrec -> 꼬리재귀라고 부름. acc와 함께 사용
 - 꼬리재귀는 자기자신만 호출하는 함수
 - 외부에서 factorial3의 결과값을 사용한다거나, 다른 값과 연산을 한다던지 하는 작업이 불가함
 - 내가 구현한 코드가 tail recursion이 아니어도 컴파일은 가능. but warning이 뜨게 됨
 - 컴파일러가 성능을 최적화하므로 performance가 일반 재귀함수에 비해 좋음. SOP(Stack overflow) 발생X
 */
tailrec fun factorial3(num: Int, acc: Int = 1): Int = when (num) { // acc-> accelerator. 누산값
    1 -> acc
    else -> factorial3(num - 1, acc * num)
}
