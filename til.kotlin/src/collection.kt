// 코틀린은 기본 immutable이므로 기존 오브젝트는 변환되지 않음
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

    /**
     *
     */
    println(list.take(3))
    // [1, 2, 3]
    println(list.filter { value -> value % 2 == 1 })
    // [1, 3, 5]

    /**
     * 조건이 true인 경우만 반환
     * filter와의 차이는 filter와는 달리 전체 순회하지 않고, false를 만난 순간 종료됨
     */
    println(list.dropWhile { value -> value % 2 == 1 }) //
    // [2, 3, 4, 5, 6]
    println(list.dropWhile { value -> value < 3 })
    // [3, 4, 5, 6]

    /** 앞에서부터 삭제 */
    println(list.drop(1))
    // [2, 3, 4, 5, 6]

    /**
     * predicate: 인자를 받아서 boolean으로 반환
     * filter는 true인 object만 리턴한다.
     */
    println(list.filter { value -> value % 2 == 0 })
    // [2, 4, 6]

    /**
     * transform : T를 받아 R로 만들어 반환
     * 같은 타입이어도 무관함
     */
    println(list.map { value -> value * value })
    // [1, 4, 9, 16, 25, 36]

}