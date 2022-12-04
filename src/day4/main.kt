package day4

import readInput

fun parseInput(input: String) =
    input
        .split(",", "-")
        .windowed(2, 2) {(lowerBound, upperBound) ->
            IntArray(upperBound.toInt() - lowerBound.toInt() + 1) { it + lowerBound.toInt() }.toSet()
        }

fun main() {

    fun part1(input: List<String>) =
        input
            .map{
                parseInput(it).let {
                    it.reduce { acc, ints -> ints.union((acc)) } == it.maxBy { it.size }
                }
        }.count { it }


    fun part2(input: List<String>) =
        input
            .map{
                parseInput(it).let {
                    it.reduce { acc, ints -> ints.intersect((acc)) }.isNotEmpty()
                }
            }.count{ it }

    val testInput = readInput("day4/test_input")
    check(part1(testInput) == 2)

    val realInput = readInput("day4/input")
    println(part1(realInput))

    val testInput2 = readInput("day4/test_input")
    check(part2(testInput2) == 4)

    val realInput2 = readInput("day4/input")
    println(part2(realInput2))

}