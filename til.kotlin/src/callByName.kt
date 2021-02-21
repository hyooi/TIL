fun main(args: Array<String>) {

    callByName()()    // "callByName"
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
    if (condtion) {
        callByValue
    }
}

fun callByName(): () -> String = {
    println("callByName")
    // shomething
    "FP"
}

fun callByValue(): String {
    println("callByValue")
    return "FP"
}