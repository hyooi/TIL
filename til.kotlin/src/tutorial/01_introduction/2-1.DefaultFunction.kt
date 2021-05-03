package tutorial.`01_introduction`

fun main() {
    printMessage("hello")
    printMessageWithPrefix("hello", "log")
    printMessageWithPrefix("hello")
    printMessageWithPrefix(prefix = "log", message = "hello")
    println(sum(1,2))
    println(multiple(2,4))
}

fun multiple(x: Int, y: Int) = x*y

fun sum(x: Int, y: Int): Int {
    return x+y
}

fun printMessageWithPrefix(message: String, prefix: String="info") {
    println("[$prefix] $message")
}

fun printMessage(message: String): Unit { //unit? 반환값 없다는 의미
    println(message)
}
