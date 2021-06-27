package tutorial.`08_ProductivityBoosters`

fun main() {
    println(format("mario", "example.com"))
    println(format("domain.com", "username"))
    println(format(userName = "foo", domain = "bar.com"))
    println(format(domain = "frog.com", userName = "pepe"))
}

fun format(userName: String, domain: String): String {
    return "$userName@$domain"
}
