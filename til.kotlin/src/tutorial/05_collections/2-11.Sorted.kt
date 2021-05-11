package tutorial.`05_collections`

fun main() {
    val shuffled = listOf(5,4,2,1,3,-10)

    println(shuffled.sorted()) //-10,1,2,3,4,5
    println(shuffled.sortedBy { -it }) //5,4,3,2,1,-10
    println(shuffled.sortedDescending()) //5,4,3,2,1,-10
    println(shuffled.sortedByDescending { kotlin.math.abs(it) }) //-10,5,4,3,2,1
}