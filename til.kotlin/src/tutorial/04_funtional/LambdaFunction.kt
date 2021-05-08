package tutorial.`04_funtional`

val upperCase1: (String) -> String = { str: String -> str.toUpperCase() }

val upperCase2: (String) -> String = { str -> str.toUpperCase() } //내부유형 유추

val upperCase3= { str: String -> str.toUpperCase() } //외부유형 유추

// val upperCase4 = { str -> str.toUpperCase() } //함께 유추는 불가능

val upperCase5: (String) -> String = { it.toUpperCase() } //암시적 it변수 이용 가능

val upperCase6: (String) -> String = String::toUpperCase

fun main() {
    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))
}