package day3

import java.io.File

fun main() {
    val diagnostics = File("src/day3/input.txt").readLines()

    var oxygenList = diagnostics
    var i = 0
    while (oxygenList.size > 1) {
        oxygenList = if (oxygenList.count { it[i] == '1' } >= oxygenList.size / 2) {
            oxygenList.filter { it[i] == '1' }
        } else {
            oxygenList.filter { it[i] == '0' }
        }
        i++
    }

    var co2sList = diagnostics
    i = 0
    while (co2sList.size > 1) {
        co2sList = if (co2sList.count { it[i] == '1' } >= co2sList.size / 2) {
            co2sList.filter { it[i] == '0' }
        } else {
            co2sList.filter { it[i] == '1' }
        }
        i++
    }

    println(oxygenList[0].toInt(2) * co2sList[0].toInt(2))
}
