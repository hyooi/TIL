package tutorial.`05_collections`

fun main() {
    val map = mapOf("key" to 42)

    println(map["key"]) //42
    println(map["key2"]) //null

    println(map.getValue("key")) //42

    val mapWithDefault = map.withDefault { it.length } //1
    println(mapWithDefault.getValue("key2")) //key2의 length인 4!

    try {
        map.getValue("anotherKey") //getValue메소드는 키가 없으면 익셉션을 발생시킴
    } catch (e: NoSuchElementException) {
        println("Message $e")
    }
}