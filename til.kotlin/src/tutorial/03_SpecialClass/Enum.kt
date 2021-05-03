package tutorial.`03_SpecialClass`

enum class State {
    IDLE, RUNNING, FINISHED
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = this.rgb and 0xFF0000 != 0
}

fun main() {
    val state = State.RUNNING
    val message = when (state) { // 컴파일러가 when절이 완전한지 유추할 수 있어 else미필요
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }

    println(message)

    val red = Color.RED
    println(red)
    println(red.containsRed())
    println(Color.BLUE.containsRed())
}