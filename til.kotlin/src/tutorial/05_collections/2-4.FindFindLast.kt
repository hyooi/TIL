package tutorial.`05_collections`

// find, findLast: 지정된 조건과 일치하는 첫째 혹은 마지막 element 반환
// 없는 경우 null반환
fun main() {
    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")
    println(words.find { it.startsWith("some") }) //something
    println(words.findLast { it.startsWith("some") }) //somehow
    println(words.find { it.contains("nothing") }) //null
}