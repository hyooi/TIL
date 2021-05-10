package tutorial.`05_collections`

//map : 컬렉션 요소 변환
//val numbers = listOf(1, -2, 3, -4, 5, -6)
fun main() {
    println(numbers.map { it*2 }) //[2, -4, 6, -8, 10, -12]
    println(numbers.map { it*3 }) //[3, -6, 9, -12, 15, -18]
}