package exercise

fun main(args: Array<String>) {

    val sumFour: (Int, Int, Int, Int) -> Int = { x1, x2, x3, x4 -> x1+x2+x3+x4 }
    val partialSumFour = sumFour.partialAppliedFunction(1, 2)

    require(partialSumFour(3, 4) == 10)

}

fun <P1, P2, P3, P4, R> ((P1, P2, P3, P4) -> R).partialAppliedFunction(x: P1,
    y: P2): (P3, P4) -> R {
        return { p3, p4 -> this(x, y, p3, p4) }
    }