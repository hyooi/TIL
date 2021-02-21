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


tailrec fun factorial3(num: Int, acc: Int = 1): Int = when (num) {
    1 -> acc
    else -> factorial3(num - 1, acc * num)
}
