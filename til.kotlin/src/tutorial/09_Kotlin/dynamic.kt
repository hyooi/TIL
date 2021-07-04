package tutorial.`09_Kotlin`


fun main() {
    val a: dynamic = "abc"
    val b: String = a

    fun firstChar(s: String) = s[0]
    println("${firstChar(a)} == ${firstChar(b)}")
    println("${a.charCodeAt(0, "dummy argument")} == ${b[0].code}")
    println(a.charAt(1).repeat(3))

    fun plus(v: dynamic) = v+2
    println("2+2=${plus(2)}")
    println("'2'+2 = ${plus("2")}")
}