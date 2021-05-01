package tutorial.introduction

fun main() {
    fun describeString(maybeString: String?) : String {
        if(maybeString != null && maybeString.isNotEmpty()) {
            return "String of length ${maybeString.length}"
        } else {
            return "Empty or null string"
        }
    }

    println(describeString("temp"))
    println(describeString(""))
}