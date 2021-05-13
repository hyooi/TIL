package tutorial.`06_ScopeFunction`

/**
 * also : apply와 비슷함
 * 그런데 it을 참조하므로 다른 메소드에 파라미터로 전달하기가 용이함
 */
fun main() {
    val jake = Person("jake", 30, "developer")
        .also {
            writeCreationLog(it)
        }
}

fun writeCreationLog(it: Person) {
    println(it)
}
