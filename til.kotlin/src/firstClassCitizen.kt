fun main(args: Array<String>) {


}

fun function(param: () -> Unit) {
    // something
}

fun function2(): () -> Unit {
    return { println("FP") }
}

val value1: () -> Unit = { println("FP") }
val value2: List<() -> Unit> = listOf({ println("FP") })
val value3: Map<String, () -> Unit> = mapOf("FP" to { println("FP") })