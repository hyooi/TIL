import practice.Cons
import practice.FpList
import practice.Nil
import practice.appendTail

fun main(args: Array<String>) {

    val intlist = Cons(1,
        Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))

    require(intlist.map { value -> "value : $value" } ==
        Cons("value : 1",
            Cons("value : 2", Cons("value : 3",
                Cons("value : 4", Cons("value : 5", Nil))))))

    require(intlist.map(Nil) { value -> "value : $value" } ==
        Cons("value : 1",
            Cons("value : 2", Cons("value : 3",
                Cons("value : 4", Cons("value : 5", Nil))))))

}

fun <T, R> FpList<T>.map(transformer: (T) -> R): FpList<R> = when(this) {
    Nil -> Nil
    is Cons -> Cons(transformer(head), tail.map(transformer))
}

tailrec fun <T, R> FpList<T>.map(acc: FpList<R>, transformer: (T) -> R): FpList<R> = when(this) {
    Nil -> acc
    is Cons -> tail.map(acc.appendTail(transformer(head)), transformer)
}