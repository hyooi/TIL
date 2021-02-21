package solution

import practice.Cons
import practice.FpList
import practice.Nil

fun main(args: Array<String>) {
    val intlist = Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))

    require(intlist.drop(0) == Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil))))))
    require(intlist.drop(3) == Cons(4, Cons(5, Nil)))
    require(intlist.drop(6) == Nil)

}

tailrec fun <T> FpList<T>.drop(n: Int): FpList<T> = when(this){
    Nil -> Nil
    is Cons -> when(n){
        0 -> this
        else -> tail.drop(n -1)
    }
}