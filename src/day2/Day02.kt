package day2

import readInput
import kotlin.math.abs
import kotlin.math.max

interface Move {
    fun toScore(): Int
}

object Rock : Move {
    override fun toScore() = 0
}
object Paper : Move {
    override fun toScore() = 1
}
object Scissors : Move {
    override fun toScore() = 2
}

fun String.toMove() = when(this) {
    "A", "X" -> Rock
    "B", "Y" -> Paper
    "C", "Z" -> Scissors
    else -> throw IllegalArgumentException()
}

fun String.toScore() = when(this) {
    "A", "X" -> 0
    "B", "Y" -> 1
    "C", "Z" -> 2
    else -> throw IllegalArgumentException()
}

fun main() {
    fun matchScore(myMove: Move, opponentMove: Move): Int {
        // Draw
        if(opponentMove.toScore() == myMove.toScore()) return 4 + myMove.toScore()
        // Lost
        if((myMove.toScore() + 1) % 3 == opponentMove.toScore()) return 1 + myMove.toScore()
        // Won
        return 7 + myMove.toScore()
    }

    fun part1(input: List<String>) = input.sumOf { match ->
        match.split(" ").let {
            matchScore(it[1].toMove(), it[0].toMove())
        }
    }

    fun part2(input: List<String>) = input.sumOf { match ->
        match.split(" ").let {
            when(it[1]) {
                "X" -> (it[0].toScore() + 2) % 3 + 1
                "Y" -> it[0].toScore() + 4
                "Z" -> (it[0].toScore() + 4 ) % 3 + 7
                else -> throw IllegalArgumentException()
            }
        }
    }
    val testInput = readInput("day2/Day02_test")
    check(part1(testInput) == 15)

    val realInput = readInput("day2/Day02")
    println(part1(realInput))

    val testInput2 = readInput("day2/Day02_test")
    check(part2(testInput2) == 12)

    val realInput2 = readInput("day2/Day02")
    println(part2(realInput2))

}
