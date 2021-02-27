package exercise

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
    is Cons -> head + tail.sum() // tail.sum에 +가 있기때문에 꼬리재귀가 아님
}

// acc가 최종 값
tailrec fun FpList<Int>.tailrecSum(acc: Int): Int = when(this) {
    Nil -> acc

    // tailrecSum만 호출해야함. tailRecSum의 결과에 무언가 연산을 하게되면 꼬리재귀X
    // 0(acc)+1+2+3+4+5
    is Cons -> tail.tailrecSum(acc + head)
}