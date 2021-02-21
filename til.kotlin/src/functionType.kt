fun main(args: Array<String>) {

    val functionType: () -> Unit
    val functionType1: (Int) -> Unit
    val functionType2: (Int, String) -> Unit

    functionType = { println("FP") }
    functionType1 = { value -> println(value.toString()) }
    functionType2 = { intValue, stringValie ->
        println("intValue $intValue, stringValue $stringValie")
    }

    functionType()              // FP
    functionType1(10)           // 10
    functionType2(10, "FP")     // intValue 10, stringVAlue FP

}