import kotlin.math.max

fun main() {

    fun part1(input: List<String>): Int {
        var maxCaloriesCarriedPerElf = 0
        var elfCaloriesCounter = 0;
        input.forEach {
            if(it == "") {
                maxCaloriesCarriedPerElf = max(maxCaloriesCarriedPerElf, elfCaloriesCounter)
                elfCaloriesCounter = 0;
            } else {
                elfCaloriesCounter += it.toInt();
            }
        }

        return maxCaloriesCarriedPerElf
    }

    fun part2(input: List<String>): Int {
        var caloriesPerElf = ArrayList<Int>()
        var elfCaloriesCounter = 0;
        input.forEach {
            if(it == "") {
                caloriesPerElf.add(elfCaloriesCounter)
                elfCaloriesCounter = 0;
            } else {
                elfCaloriesCounter += it.toInt();
            }
        }
        caloriesPerElf.sortDescending()
        return caloriesPerElf[0] + caloriesPerElf[1] + caloriesPerElf[2]
    }

    val calories = readInput("Day01")
    val part1Answer = part1(calories)
    println(part1Answer)

    val part2Answer = part2(calories)
    println(part2Answer)
}
