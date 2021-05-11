package tutorial.`05_collections`

// partition : predicate에 따라 컬렉션을 분할
fun main() {
//    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val evenOdd = numbers.partition { it%2 == 0 }
    val (positives, negatives) = numbers.partition { it > 0 }

    println(evenOdd)
    println("positive : $positives, negatives: $negatives")
}