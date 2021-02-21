package solution

fun main(args: Array<String>) {

    val sumFour: (Int, Int, Int, Int) -> Int = { p1, p2, p3, p4 ->
        p1 + p2 + p3 + p4
    }
    val partialSumFour = sumFour.partialAppliedFunction(1, 2)
//
    require(partialSumFour(3, 4) == 10)

}

fun <P1, P2, P3, P4, R> ((P1, P2, P3, P4) -> R).partialAppliedFunction(x: P1,
    y: P2): (P3, P4) -> R {
    return { p3, p4 ->
        this(x, y, p3, p4)
    }
}