package tutorial.`02_controlFlow`

fun main() {
    val authors = setOf("Shakespear", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespear", "Hemingway")

    println(authors == writers) //구조비교. 순서를 무시하므로 true리턴
    println(authors === writers) //참조비교. false 리턴
}