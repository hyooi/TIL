package tutorial.`06_ScopeFunction`

/**
 * run: 코드블록을 실행하고 그 결과 반환함(let과 동일)
 * 그런데 run에서는 this를 통해 접근 가능한 점이 다름
 *
 */
fun main() {
    fun getNullableLength(ns: String?) {
        println("for \$ns\":")
        ns?.run {
            println("\tis empty? " + isEmpty()) //run에서는 object의 멤버에 name없이 접근 가능
            println("\tlength = $length")
            length
        }
    }

    getNullableLength(null)
    getNullableLength("")
    getNullableLength("some string with kotlin")
}