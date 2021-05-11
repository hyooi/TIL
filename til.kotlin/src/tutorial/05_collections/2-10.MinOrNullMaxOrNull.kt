package tutorial.`05_collections`

fun main() {
    val numbers = listOf(1,2,3)
    val empty = emptyList<Int>()
    val only = listOf(3)

    println("Numbers: $numbers, min = ${numbers.minOrNull()} max = ${numbers.maxOrNull()}") //1,3
    println("Empty: $empty, min = ${empty.minOrNull()}, max = ${empty.maxOrNull()}") //null, null
    println("Only: $only, min = ${only.minOrNull()}, max = ${only.maxOrNull()}") //3, 3
}