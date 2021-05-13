package tutorial.`06_ScopeFunction`

/**
 * let: 범위지정, null체크 시 사용
 * 코드블럭 실행 후 마지막 결과 반환함
 */
fun main() {
    val empty = "test".let { //test에 대해 코드블록 호출
        customPrint(it)
        it.isEmpty() //해당 값 반환
    }
    println(" is empty: $empty")

    fun printNonNull(str: String?) {
        println("Printing \"$str\":")

        str?.let { //safe call했으므로 null이 아닌 경우에서만 실행됨
            print("\t")
            customPrint(it)
            println()
        }
    }

    printNonNull(null)
    printNonNull("my string")
}

fun customPrint(it: String) {
    println("------$it")
}
