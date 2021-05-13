package tutorial.`06_ScopeFunction`

/**
 * with: 오브젝트의 멤버에 간단하게 액세스 가능
 * 인스턴스명 생략이 가능하다
 */
fun main() {
    val configuration = Configuration("localhost", "22")
    with(configuration) {
        println("$host:$port")
    }

    println("${configuration.host}:${configuration.port}") //이거대신 with사용 가능
}

class Configuration (
    val host:String,
    val port:String
)
