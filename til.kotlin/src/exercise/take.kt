package exercise

import practice.Cons
import practice.FpList
import practice.Nil
import practice.appendTail
import java.lang.NullPointerException

fun main(args: Array<String>) {
    val intlist = Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))
    require(intlist.take(0) == Nil)
    require(intlist.take(3) == Cons(1, Cons(2, Cons(3, Nil))))
    require(intlist.take(6) == Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil))))))

    require(intlist.take(0, Nil) == Nil)
    require(intlist.take(3, Nil) == Cons(1,
        Cons(2, Cons(3, Nil))))
    require(intlist.take(6, Nil) == Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil))))))

}

fun <T> FpList<T>.take(n: Int): FpList<T> = when(this) {
    Nil -> Nil
    is Cons -> when(n) {
       0 -> Nil
       else -> Cons(head, tail.take(n-1))
    }
}

tailrec fun <T> FpList<T>.take(n: Int, acc: FpList<T>): FpList<T> = when(this) {
    Nil -> acc //꼬리재귀의 종료조건
    is Cons -> when(n) {
        0 -> acc
        else -> tail.take(n-1, acc.appendTail(head))
    }
}