package day4

import java.io.File

fun main() {
    var input = File("src/day4/input.txt").readLines()

    //Get balls
    val balls = input[0].split(",").map { it.toInt() }

    val boards = ArrayList<Board>()

    // Parse all the boards
    input = input.drop(2)
    while (input.isNotEmpty()) {
        boards.add(Board.parse(input.takeWhile { it != "" }))
        input = input.dropWhile { it != "" }.drop(1)
    }

    val winningBoards = ArrayList<Board>()
    //Play the game of Bingus
    var currBall = -1
    while (winningBoards.size < boards.size) {
        currBall++
        boards.forEach { it.markNum(balls[currBall]) }
        winningBoards += boards.filter { it.hasWon() && it !in winningBoards }
    }

    println("Losing score: ${balls[currBall] * winningBoards.last().unmarkedSum()}")
}
