package tutorial.controlFlow

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")

fun main() {
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }

    do { //한번은 무조건 실행!
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}