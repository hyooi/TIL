package tutorial.`05_collections`

val openIssues: MutableSet<String> = mutableSetOf("uniqueDescr1","uniqueDescr2","uniqueDescr3")

fun addIssue(uniqueDesc: String): Boolean {
    return openIssues.add(uniqueDesc)
}

fun getStatusLog(isAdded: Boolean): String {
    return if (isAdded) "registered correctly." else "marked as duplicate and rejected"
}

fun main() {
    val aNewIssue = "uniqueDescr4"
    val anIssueAlreadyIn = "uniqueDescr2"

    println("Issue $aNewIssue ${getStatusLog(addIssue(aNewIssue))}")                              // 4
    println("Issue $anIssueAlreadyIn ${getStatusLog(addIssue(anIssueAlreadyIn))}")
}