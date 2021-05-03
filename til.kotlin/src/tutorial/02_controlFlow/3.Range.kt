package tutorial.`02_controlFlow`

fun main() {
    /* 숫자 RANGE */
    for(i in 0..3) { //0123
        print(i)
    }
    println()

    for(i in 0 until 3) { //012
        print(i)
    }
    println()

    for(i in 2..8 step 2) { //2468
        print(i)
    }
    println()

    for(i in 3 downTo 0) { //3210
        print(i)
    }
    println()

    /* 캐릭터 Range */
    for(c in 'a'..'d') { //abcd
        print(c)
    }
    println()

    for(c in 'z' downTo 's' step 2) { //zxvt
        print(c)
    }
    println()

    /* IF Range */
    val x=2
    if(x in 1..5) {
        println("x is in range from 1 to 5")
    }

    if(x !in 6..10) {
        println("x is not in range from 6 to 10")
    }
}
