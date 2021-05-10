package tutorial.`05_collections`

//filter : 컬렉션 필터링
val numbers = listOf(1, -2, 3, -4, 5, -6)
val positives = numbers.filter { it > 0 }
val negatives = numbers.filter { it < 0 }

fun main() {
    println(positives) //[1, 3, 5]
    println(negatives) //[-2, -4, -6]
}