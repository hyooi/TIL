package tutorial.`05_collections`

//val numbers = listOf(1, -2, 3, -4, 5, -6)
fun main() {
    println(numbers.count()) //6
    println(numbers.count { it%2 ==0 }) //3
}