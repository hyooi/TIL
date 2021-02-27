fun main(args: Array<String>) {

    val rgb: ColorInterface = Pink()

    val result = when (rgb) {
        is Red -> "Red" //is = instanceOf
        is Green -> "Green"
        is Blue -> "Blue"
        else -> throw IllegalArgumentException() //곱타입인 경우 어떤 케이스가 추가될지 알 수 없으므로 반드시 else필요
    }

    val rgb2: Color = Color.PINK

    /**
     * 패턴 매칭 시 값인 경우엔 is가 붙지 않음
     * 합타입의 경우 Color가 추가됐을 때, 하기에 추가하지 않으면 컴파일 타임에 에러가 발생함
     */
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

/**
 * sealed class를 상속받은 경우에만 생성 가능.
 * Just, None 두가지만 생성 가능한 가짓수임. 합타입이라고도 부름
 * */
sealed class Option<out T>
data class Just2<T>(val value: T) : Option<T>()
object None2: Option<Nothing>()