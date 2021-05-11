package tutorial.`05_collections`

/**
 * zip: 두 컬렉션을 병합. 기본적으로 pair로 병합됨.
 * - 결과 컬렉션은 원본 컬렉션의 최소 크기와 동일
 * - 자체 구조 또한 정의 가능
 */
fun main() {
    val A = listOf("a","b","c")
    val B = listOf(1,2,3,4)

    println(A zip B)
    println(A.zip(B) {a,b -> "$a$b"})
}