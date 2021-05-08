package tutorial.`04_funtional`

data class Item(val name:String, val price: Float)

data class Order(val items: Collection<Item>)

//Order클래스에 확장 함수 추가
fun Order.maxPricedItemValue(): Float = this.items.maxByOrNull { it.price }?.price?: 0F
fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"

//Order클래스에 확장 프로퍼티 추가
val Order.commaDelimitedItemNames: String
    get() = items.joinToString { it.name }

//null safe
fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"

fun main() {
    val order = Order(listOf(
        Item("Bread", 25.0F),
        Item("Wine", 29.0F),
        Item("Water", 12.0F))
    )

    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Max priced item name: ${order.maxPricedItemName()}")
    println("Items: ${order.commaDelimitedItemNames}")
}