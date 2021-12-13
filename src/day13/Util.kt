package day13

import kotlin.math.abs

enum class Axis { X, Y }

data class Fold(val axis: Axis, val position: Int)

data class Coordinate(val x: Int, val y: Int)

data class Field(val dots: List<Coordinate>) {
    fun horizFold(position: Int): Field {
        val res = ArrayList<Coordinate>()

        for (dot in dots) {
            if (dot.y < position) {
                res.add(dot)
            } else {
                res.add(Coordinate(dot.x, position - abs(dot.y - position)))
            }
        }
        return Field(res.distinct())
    }


    fun vertFold(position: Int): Field {
        val res = ArrayList<Coordinate>()

        for (dot in dots) {
            if (dot.x < position) {
                res.add(dot)
            } else {
                res.add(Coordinate(position - abs(dot.x - position), dot.y))
            }
        }
        return Field(res.distinct())
    }


    override fun toString(): String {
        val xLen = dots.maxOf { it.x }
        val res = Array(dots.maxOf { it.y } + 1) { "" }
        for (y in res.indices) {
            val xs = dots.filter { it.y == y }.map { it.x }
            val line = StringBuilder()
            for (x in 0..xLen) {
                line.append(if (x in xs) '#' else '.')
            }
            res[y] = line.toString()
        }
        return res.joinToString("\n")
    }

}
