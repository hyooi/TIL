package exercise

fun main(args: Array<String>) {

    val product: (Int, Int) -> Int
    product = {
        int1, int2 -> int1*int2
    }
    require(product(3, 5) == 15)

    val appendString: (String, String, String) -> String
    appendString = {
        str1, str2, str3 -> str1+str2+str3
    }
    require(appendString("Hello", "FP", "Kotlin") == "HelloFPKotlin")
}