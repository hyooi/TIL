package practice

sealed class FpList<out T>

data class Cons<out T>(val head: T, val tail: FpList<T>) : FpList<T>()
object Nil : FpList<Nothing>()

fun FpList<Int>.product(): Int = when (this) {
    Nil -> 1
    is Cons -> head * tail.product()
}

fun <T> FpList<T>.appendTail(value: T): FpList<T> = when (this) {
    Nil -> Cons(value, Nil)
    is Cons -> Cons(head, tail.appendTail(value))
}

fun <T> FpList<T>.addHead(value: T): FpList<T> = when (this) {
    Nil -> Cons(value, Nil)
    is Cons -> Cons(value, this)
}

tailrec fun FpList<Int>.tailrecProduct(acc: Int): Int = when (this) {
    Nil -> acc
    is Cons -> tail.tailrecProduct(acc * head)
}

fun main(args: Array<String>) {

    val intlist = Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))

    require(intlist.product() == 120)
    require(intlist.tailrecProduct(1) == 120)

    require(intlist.appendTail(6) == Cons(1, Cons(2,
        Cons(3, Cons(4, Cons(5, Cons(6, Nil)))))))
    require(intlist.addHead(0) == Cons(0, Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))))

}