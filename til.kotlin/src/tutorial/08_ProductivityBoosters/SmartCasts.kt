package tutorial.`08_ProductivityBoosters`

import java.time.LocalDate
import java.time.chrono.ChronoLocalDate

fun main() {
    val date: ChronoLocalDate? = LocalDate.now() //nullable 변수

    if(date != null) {
        println(date.isLeapYear) //not null으로 캐스팅
    }

    if(date != null && date.isLeapYear) { //조건 내에서 스마트캐스트
        println("It's a leap year!")
    }

    if(date == null || !date.isLeapYear) { //조건 내에서 스마트캐스트
        println("There's no Feb 29 this year...")
    }

    if(date is LocalDate) { //하위 유형으로 스마트캐스트
        val month = date.monthValue
        println(month)
    }
}