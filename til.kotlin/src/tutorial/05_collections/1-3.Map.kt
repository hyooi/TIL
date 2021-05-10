package tutorial.`05_collections`

const val POINTS_X_PASS = 15
val EZPassAccounts = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
val EZPassReport = EZPassAccounts

fun updatePointsCredit(accountId: Int) {
    if (EZPassAccounts.containsKey(accountId)) {
        println("Updating $accountId...")
        EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS
    } else {
        println("Error: Trying to update a non-existing account (id: $accountId)")
    }
}

fun accountsReport() {
    println("EZ-Pass report:")
    EZPassReport.forEach{ (k, v) -> println("ID $k: credit $v") }
}

fun main() {
    accountsReport()
    updatePointsCredit(1)
    updatePointsCredit(1)
    updatePointsCredit(5)
    accountsReport()
}