fun main(args: Array<String>) {

    higherOrderFunction1 { println("FP") }
    higherOrderFunction2()
    higherOrderFunction3 { println("FP") }

}

fun higherOrderFunction1(func: () -> Unit) {
    func()
}

fun higherOrderFunction2(): () -> Unit {
    return { println("FP") }
}

fun higherOrderFunction3(func: () -> Unit): () -> Unit {
    return func
}