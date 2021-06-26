package tutorial.`07_delegation`

class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main() {
    val user = User(mapOf(
        "name" to "John Doe",
        "age" to 25
    ))

    println("name = ${user.name}, age = ${user.age}")
}