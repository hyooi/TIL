package tutorial.`01_introduction`

fun main() {
    fun printAll(vararg messages: String) {
        for(m in messages) println(m)
    }
    printAll("hello", "hallo", "salut", "hola", "안녕")

    fun printAllWithPrefix(vararg messages: String, prefix: String) {
        for(m in messages) println(prefix+m)
    }
    printAllWithPrefix(
        "hello", "hallo", "salut", "hola", "안녕",
        prefix = "greeting: "
    )

    fun log(vararg entities: String) {
        printAll(*entities) //entities는 런타임때 배열, vararg로 전달하기 위해 *붙임
    }
    log("hello", "hallo", "salut", "hola", "안녕")
}
