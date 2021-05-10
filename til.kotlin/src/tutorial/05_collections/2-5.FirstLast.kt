package tutorial.`05_collections`
/*
 - first, last: 조건에 따라 첫번째, 마지막 요소 반환
 - firstOrNull, lastOrNull: 매칭되는 엘리먼트가 없으면 null반환하는 점이 다름
 */
//val numbers = listOf(1, -2, 3, -4, 5, -6)
fun main() {
    println(numbers.first()) //1
    println(numbers.last()) //-6

    println(numbers.first { it%2 == 0 }) //-2
    println(numbers.last { it%2 != 0 }) //5

    val words = listOf("foo", "bar", "baz", "faz")
    val empty = emptyList<String>()

    println(empty.firstOrNull()) //null
    println(empty.lastOrNull()) //null

    println(words.firstOrNull { it.startsWith('f') }) //foo
    println(words.firstOrNull { it.startsWith('z') }) //null
    println(words.lastOrNull { it.endsWith('f') }) //null
    println(words.lastOrNull { it.endsWith('z') }) //faz
}