val lazyValue: String by lazy {
    println("시간이 오래 걸리는 작업")
    "hello"
}

fun main(args: Array<String>) {
    println(lazyValue)
    println(lazyValue)

    val infiniteValue = generateSequence(0) { it + 1 }
    infiniteValue
        .take(5)
        .forEach { print("$it ") }   //0 1 2 3 4

    val lazyValue2: () -> Unit = {
        println("FP")
    }

    lazyValue2      //
    lazyValue2      //
    lazyValue2      //
    lazyValue2()    // FP
}

