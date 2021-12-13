package day13

import java.io.File


fun main() {
    val lines = File("src/day13/input.txt").readLines()

    var field = Field(lines.takeWhile { it.isNotEmpty() }
        .map { it.split(",").let { Coordinate(it[0].toInt(), it[1].toInt()) } }.toSet())

    val folds = lines.dropWhile { it.isNotEmpty() }.drop(1).map {
        it.drop(11).split("=").let { Fold(if (it[0] == "x") Axis.X else Axis.Y, it[1].toInt()) }
    }

    for (fold in folds){
        field = when (fold.axis) {
            Axis.X -> field.vertFold(fold.position)
            Axis.Y -> field.horizFold(fold.position)
        }
        println()
        println(field)
    }

}

