package tutorial.`05_collections`

// any, all, none: 조건 맞는 컬렉션 요소 확인(true/false)
// val numbers = listOf(1, -2, 3, -4, 5, -6)
fun main() {
    println(numbers.any { it<0 }) //true
    println(numbers.any { it>6 }) //false

    println(numbers.all { it%2 ==0 }) //false
    println(numbers.all { it<6 }) //true

    println(numbers.none { it%2 == 1 }) //false
    println(numbers.none { it>6 }) //true
}