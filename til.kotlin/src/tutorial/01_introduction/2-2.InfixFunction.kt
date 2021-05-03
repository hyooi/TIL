package tutorial.`01_introduction`

fun main() {
    infix fun Int.times(str: String) = str.repeat(this) //times: infix extension함수
    println(2 times "bye ")

    val pair = "ferrari" to "katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "lucase"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia

    println(sophia.likedPeople.get(0).name)
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
    }
}