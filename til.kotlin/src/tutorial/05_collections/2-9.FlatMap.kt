package tutorial.`05_collections`

fun main() {
    val fruitsBag = listOf("apple", "orange", "banana", "grapes")
    val clothesBag = listOf("shirts", "pants", "jeans")
    val cart = listOf(fruitsBag, clothesBag)

    println(cart)
    println(cart.map { it })
    println(cart.flatten())
}