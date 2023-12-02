package common

abstract class Day(private val day: String) {
    abstract fun part1(input: List<String>): Int

    abstract fun part2(input: List<String>): Int

    fun run(filename: String = "Day$day") {
        colored {
            println("AOC 2023 - Day $day - ${getPath(filename).toAbsolutePath()}".bold.blue)
            val input = readInput(filename)
            println("Part 1: ".bold.purple + part1(input))
            println("Part 2: ".bold.purple + part2(input))
        }
    }
}
