package solution

import practice.Cons
import practice.FpList
import practice.Nil

fun main(args: Array<String>) {
    val intlist = Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))

    require(intlist.sum() == 15)
    require(intlist.tailrecSum(0) == 15)
}

fun FpList<Int>.sum(): Int = when (this) {
    Nil -> 0
    is Cons -> head + tail.sum()
}


tailrec fun FpList<Int>.tailrecSum(acc: Int): Int = when(this){
    Nil -> acc
    is Cons ->  tail.tailrecSum(acc + head)
}