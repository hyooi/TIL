package tutorial.`03_SpecialClass`

// 데이터 클래스: 복사, 문자열 가져오기 등이 기본 제공되는 클래스
data class User(val name: String, val id: Int)

fun main() {
    val user = User("Alex", 1)
    println(user) //toString자동생성

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    println("user == secondUser: ${user == secondUser}") // 자동생성된 equals는 모든 property가 같으면 같은 객체로 취급
    println("user == thirdUser: ${user == thirdUser}")

    println(user.hashCode()) //동일한 데이터 클래스는 동일한 hashcode를 가짐
    println(secondUser.hashCode())

    println(user.copy())
    println(user.copy("Max")) //특정 property 변경 가능
    println(user.copy(id = 2))

    println("name = ${user.component1()}")
    println("id = ${user.component2()}")
}