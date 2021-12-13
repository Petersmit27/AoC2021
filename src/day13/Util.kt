package day13

import kotlin.math.abs

enum class Axis { X, Y }

data class Fold(val axis: Axis, val position: Int)

data class Coordinate(val x: Int, val y: Int)

data class Field(val dots: Set<Coordinate>) {

    fun horizFold(position: Int) =
        Field(dots.map { dot -> Coordinate(dot.x, position - abs(dot.y - position)) }.toSet())

    fun vertFold(position: Int) =
        Field(dots.map { dot -> Coordinate(position - abs(dot.x - position), dot.y) }.toSet())


    override fun toString(): String {
        val xLen = dots.maxOf { it.x }
        val res = Array(dots.maxOf { it.y } + 1) { "" }
        for (y in res.indices) {
            val xs = dots.filter { it.y == y }.map { it.x }
            val line = StringBuilder()
            for (x in 0..xLen) {
                line.append(if (x in xs) '█' else ' ')
            }
            res[y] = line.toString()
        }
        return res.joinToString("\n")
    }

}
