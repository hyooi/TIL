package tutorial.`03_SpecialClass`

import java.util.*

class LuckDispatcher { //일반 object
    fun getNumber() {
        println(Random().nextInt(90))
    }
}

fun main() {
    LuckDispatcher().getNumber()
    LuckDispatcher().getNumber()

}