package tutorial.`01_introduction`

fun main() {
    var a : String = "initial" // 가변
    println(a)

    val b: Int = 1 // 타입 지정 불변
    val c = 3 //타입 미지정 불변

    val d : Int
    if (1==1) {
        d = 1
    } else {
        d = 2
    }

    println(d)
}
