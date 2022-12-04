package day3

import readInput

fun Char.toPriority(): Int {
    if(this.isLowerCase())
        return this.code - 96
    return this.code - 38
}

fun <A> setIntersect(a: Set<A>, b: Set<A>) = a.intersect(b)

fun main() {

    fun part1(input: List<String>) = input.sumOf {
            it.windowed(it.length/2, it.length/2).let { (firstHalf, secondHalf) ->
                firstHalf.toSet().intersect(secondHalf.toSet()).let { commonTypes ->
                    commonTypes.sumOf(Char::toPriority)
                }
            }
        }

    fun part2(input: List<String>) = input.windowed(3, 3) { elfGroup ->
        elfGroup.map(String::toSet).reduce(::setIntersect).toList()[0].toPriority()
    }.sum()

    val testInput = readInput("day3/test_input")
    check(part1(testInput) == 157)

    val realInput = readInput("day3/input")
    println(part1(realInput))

    val testInput2 = readInput("day3/test_input")
    check(part2(testInput2) == 70)

    val realInput2 = readInput("day3/input")
    println(part2(realInput2))

}