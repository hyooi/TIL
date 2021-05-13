package tutorial.`06_ScopeFunction`

/**
 * 객체 초기화에 편리함
 */
fun main() {
    val jake = Person()
    val stringDescription = jake.apply {
        name = "jake"
        age = 30
        about = "android developer"
    }.toString()

    println(stringDescription)
}

class Person {
    constructor()
    constructor(name: String, age: Int, about: String) {
        this.name = name
        this.age = age
        this.about = about
    }

    var name: String? = null
    var age: Int? = null
    var about: String? = null

    override fun toString(): String {
        return "name: $name, age: $age, about: $about"
    }
}