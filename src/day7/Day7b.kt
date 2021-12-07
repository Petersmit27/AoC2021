package day7

import java.io.File
import kotlin.math.abs

fun main() {
    val krabs = File("src/day7/input.txt").readLines()[0].split(",").map { it.toInt() }
    println(Array(krabs.maxOrNull()!! - krabs.minOrNull()!!) { currPos -> krabs.sumOf { krabPos -> Array(abs(krabPos - currPos)) { it + 1 }.sum() } }.minOrNull())
}
