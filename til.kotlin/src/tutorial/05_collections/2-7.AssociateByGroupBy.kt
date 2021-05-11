package tutorial.`05_collections`

/**
 * 특정 키에 따라 인덱싱된 컬렉션 요소로 map을 생성, 값selector를 옵셔널하게 선택 가능
 * map은 컬렉션의 원래 순서와 동일함
 *
 * AssociateBy : GroupBy와 동일한 key를 사용해도 마지막 맞는 element를 value로 사용함(key에 따른 value가 하나만 나옴!)
 * GroupBy: 모든 적합한 요소를 build하고 value로 사용
 */
fun main() {
    data class Person(val name: String, val city: String, val phone: String)

    val people = listOf(
        Person("John", "Boston", "+1-888-123456"),
        Person("Sarah", "Munich", "+49-777-789123"),
        Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        Person("Vasilisa", "Saint-Petersburg", "+7-999-123456")
    )

    println(people.associateBy { it.phone })
    println(people.associateBy(Person::phone, Person::city))
    println(people.groupBy(Person::city, Person::name))
    println(people.associateBy(Person::city, Person::name))
}