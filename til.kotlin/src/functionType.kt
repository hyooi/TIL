fun main(args: Array<String>) {
    /*
    - return이라는 값이 없음. 마지막 줄이 리턴 값이 됨
    - 따라서 선언 시의 리턴타입과, 함수 마지막 줄의 값은 같아야 함
     */
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