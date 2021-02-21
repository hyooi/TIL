fun main(args: Array<String>) {

    var mutableInt: Int = 10
    mutableInt = 5

    var mutableString: String = "FP"
    mutableString = "Kotlin"

//    val immutableInt: Int = 10
//    immutableInt = 5    // Error
//
//    val immutableString: String = "FP"
//    immutableString = "Kotlin"  // Error

    var mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
    mutableList.add(10)

    println(mutableList) // [1, 2, 3, 10]

    val immutableList: List<Int> = listOf(1, 2, 3)
//    immutableList.add(10)   // Error

    println(immutableList)  // [1, 2, 3]
    immutableList.plus(10)
    println(immutableList)  // [1, 2, 3]
    println(immutableList.plus(10))  // [1, 2, 3, 10]
    val newList = immutableList.plus(10)
    println(immutableList)  // [1, 2, 3]
    println(newList)        // [1, 2, 3, 10]
}