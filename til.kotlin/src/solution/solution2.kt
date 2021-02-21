package solution

fun main(args: Array<String>) {

    val product: (Int, Int) -> Int = { x, y -> x * y }
    require(product(3, 5) == 15)

    val appendString: (String, String, String) -> String = { x, y, z -> x + y + z }
    require(appendString("Hello", "FP", "Kotlin") == "HelloFPKotlin")

}