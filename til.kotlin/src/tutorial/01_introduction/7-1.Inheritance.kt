package tutorial.`01_introduction`

open class Dog { // kotlin클래스는 기본적으로 파이널. 따라서 상속가능하게 하기 위해 open을 붙여야함
    open fun sayHello() {
        println("wow wow!")
    }
}

class Yorkshire: Dog() {
    override fun sayHello() {
        println("wif wif!")
    }
}

fun main() {
    val dog: Dog = Yorkshire()
    dog.sayHello()
}