fun main(args: Array<String>) {

    val result = func(0)
        .map { func2(it, 10) }
        .map { func2(it, 0) }
        .map { func2(it, 4) }

    println(result)    // -1
}

fun func(value: Int): Maybe<Int> {
    return try {
        Just(10 / value)
    } catch (e: Exception) {
        None
    }
}

fun func2(x: Int, y: Int): Int =
    x * y

/**
 * Exception처리할 용도
 * 값이 있다면 Just로 래핑하고, 없다면 None으로 래핑
 * */
sealed class Maybe<out T> {
    abstract fun <R> map(transformer: (T) -> R): Maybe<R>
}

data class Just<out T>(val value: T) : Maybe<T>() {
    override fun <R> map(transformer: (T) -> R): Just<R> = Just(transformer(value))
}

object None : Maybe<Nothing>() {
    override fun <R> map(transformer: (Nothing) -> R): Maybe<R> = None
}