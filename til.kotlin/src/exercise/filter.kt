import practice.Cons
import practice.FpList
import practice.Nil

fun main(args: Array<String>) {

    val intlist = Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))

    require(intlist.filter { value -> value % 2 == 0 } ==
        Cons(2, Cons(4, Nil)))

    require(intlist.filter(Nil) { value -> value % 2 == 0 } ==
        Cons(2, Cons(4, Nil)))

}

fun <T> FpList<T>.filter(predicate: (T) -> Boolean): FpList<T> = TODO()

tailrec fun <T> FpList<T>.filter(acc: FpList<T>, predicate: (T) -> Boolean): FpList<T> = TODO()