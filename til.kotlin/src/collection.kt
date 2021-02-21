fun main(args: Array<String>) {

    val list = listOf(1, 2, 3, 4, 5, 6)
    val list1 = listOf("a", "b", "c", "d", "e", "f")

    println(list1.foldRight("") { value, acc -> acc + value })
    // fedcba
    println(list1.fold("") { acc, value -> acc + value })
    // abcdef
    println(list.foldRight(0) { value, acc -> acc + value })
    // 21
    println(list.fold(0) { acc, value -> acc + value })
    // 21
    println(list.groupBy { value -> value % 2 })
    // {1=[1, 3, 5], 0=[2, 4, 6]}
    println(list.take(3))
    // [1, 2, 3]
    println(list.filter { value -> value % 2 == 1 })
    // [1, 3, 5]
    println(list.dropWhile { value -> value % 2 == 1 })
    // [2, 3, 4, 5, 6]
    println(list.dropWhile { value -> value < 3 })
    // [3, 4, 5, 6]
    println(list.drop(1))
    // [2, 3, 4, 5, 6]
    println(list.filter { value -> value % 2 == 0 })
    // [2, 4, 6]
    println(list.map { value -> value * value })
    // [1, 4, 9, 16, 25, 36]

}