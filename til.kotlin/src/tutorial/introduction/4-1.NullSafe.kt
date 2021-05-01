package tutorial.introduction

fun main() {
    var neverNull: String = "This can't be null"

    var nullable: String? = "You can keep a null here"
    nullable = null

    var inferredNonNull = "The compiler assumes non-null. can't be null"
    fun strLength(notNull: String): Int {
        return notNull.length
    }

    strLength(neverNull)
//    strLength(nullable) compile error
}
