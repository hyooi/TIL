/*
- 함수의 값을 전달하지 않고, 함수의 이름을 전달할 수 있다.
- 함수의 이름을 전달하면, 전달하는 시점에 함수가 실행되지 않는다.
- 특정 상황에 따라 크고 무서운 연산을 하거나, 하지 않을 경우 이름에 의한 호출을 하면 효율적
- 이러한 연산을 lazy evaluation이라고 부름
 */
fun main(args: Array<String>) {

    callByName()()    // "callByName"
    callByName()    //
    callByValue()     // "callByValue"

    doCallByValue(true, callByValue())
    // "callByValue"
    doCallByValue(false, callByValue())
    // "callByValue"

    doCallByName(true, callByName())
    // "callByName"
    doCallByName(false, callByName())
    // ""
}

fun doCallByName(condtion: Boolean, callByName: () -> String) {
    if (condtion) {
        callByName()
    }
}

fun doCallByValue(condtion: Boolean, callByValue: String) {
    if (condtion) { //false로 들어와도 doCallByValue를 호출하는 순간 평가가 되어 출력됨
        callByValue
    }
}

// 반환 타입이 함수이므로 callByName()만 하면 평가가 되지 않음. callByName()()해야 비로소 평가되면서 print됨
fun callByName(): () -> String = {
    println("callByName")
    // shomething
    "FP"
}

fun callByValue(): String {
    println("callByValue")
    return "FP"
}