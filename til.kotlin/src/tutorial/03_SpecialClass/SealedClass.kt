package tutorial.`03_SpecialClass`

/**
 * sealed class : 상속가능 클래스 지정 가능
 * sealed class는 동일한 파일 안에서만 서브클래싱 가능함. 외부에서는 불가
 */
sealed class Mammal(val name: String)

class Cat(catName: String) : Mammal(catName)
class Human(humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal) : String {
    return when (mammal) {
        is Human -> "Hello ${mammal.name}; You're working as a ${mammal.job}"
        is Cat -> "Hello ${mammal.name}"
    }
}

fun main() {
    println(greetMammal(Cat("Snowy")))
}