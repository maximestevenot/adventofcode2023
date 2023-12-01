package common

abstract class Day(private val day: String) {
    private val bold = "\u001B[1m"
    private val reset = "\u001B[0m"
    abstract fun part1(input: List<String>): Int

    abstract fun part2(input: List<String>): Int

    fun run(filename: String= "Day$day") {
        val input = readInput(filename)
        println(bold + "AOC 2023 - Day $day - ${getPath(filename).toAbsolutePath()}\n")
        println(bold + "Part 1: " + reset + part1(input))
        println(bold + "Part 2: " + reset + part2(input))
    }
}
