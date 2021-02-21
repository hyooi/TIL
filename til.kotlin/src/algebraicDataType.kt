fun main(args: Array<String>) {

    val rgb: ColorInterface = Pink()

    val result = when (rgb) {
        is Red -> "Red"
        is Green -> "Green"
        is Blue -> "Blue"
        else -> throw IllegalArgumentException()
    }

    val rgb2: Color = Color.PINK

    val result2 = when (rgb2) {
        Color.RED -> "Red"
        Color.BLUE -> "Blue"
        Color.GREEN -> "Green"
        Color.PINK -> "Pink"
    }
}

interface ColorInterface

class Red : ColorInterface
class Green : ColorInterface
class Blue : ColorInterface
class Pink : ColorInterface

data class Dog(val name: String, val age: Int)

enum class Color {
    RED, GREEN, BLUE, PINK
}
