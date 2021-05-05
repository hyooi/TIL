package tutorial.`03_SpecialClass`

import java.util.*

class LuckDispatcher { //일반 object
    fun getNumber() {
        println(Random().nextInt(90))
    }
}

/**
 * object : 데이터타입을 가지는 싱글톤 오브젝트
 * no class, no 생성자, 지연로딩! 실제 사용 시 인스턴스가 생성됨
 *
 */
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {
    val dayRates = object { //단일 오브젝트 생성
        var standard : Int = 30 * standardDays;
        var festivity : Int = 50 * festivityDays;
        var special : Int = 100 * specialDays;
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special
    println("Total price : $$total")
}

object DoAuth {
    fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

/**
 * companion : 자바의 static method와 유사. 클래스명으로 함수 호출 가능
 *
 */
class BigBen {
    companion object {
        fun getBongs(nTimes: Int) {
            for (i in 1 .. nTimes) {
                println("BONG ")
            }
        }
    }
}

fun main() {
    LuckDispatcher().getNumber()
    LuckDispatcher().getNumber()

    rentPrice(10, 2, 1)
    DoAuth.takeParams("foo", "qwerty") //이 때 DoAuth오브젝트가 생성됨
    BigBen.getBongs(12)
}