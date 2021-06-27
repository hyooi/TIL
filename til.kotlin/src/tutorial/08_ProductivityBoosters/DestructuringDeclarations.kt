package tutorial.`08_ProductivityBoosters`

data class User(val username: String, val email: String)

fun getUser() = User("Mary", "mary@somewhere.com")

class Pair<K,V>(private val first: K, private val second: V) {
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}

fun main() {
    val (x,y,z) = arrayOf(5, 10, 15)
    println("x: $x, y: $y, z: $z")

    val map = mapOf("alice" to 21, "bob" to 25)
    for ((name, age) in map) {
        println("$name is $age years old")
    }
    println()

//    val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76))

    val user = getUser()
    val (username, email) = user
    println(username == user.component1())
    println(email == user.component2())

    val(_, emailAddress) = getUser()
    println(emailAddress)
    println()

    val (num, name) = Pair(1, "one")
    println("num = $num, name = $name")
}

