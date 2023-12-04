import common.Day
import kotlin.math.pow

class Day04 : Day("04") {

    override fun part1(input: List<String>): Int {
        return parseGames(input)
            .map { it.first to parseNumbers(it.second) }
            .map { it.first to computeScore(it.second) }
            .onEach { println(it) }
            .sumOf { it.second }
    }

    override fun part2(input: List<String>): Int {
        return 0
    }

    companion object {
        private fun parseGames(input: List<String>) = input
            .map { it.split(":") }
            .map { it[0].replace("Card", "").trim().toInt() to it[1].trim() }

        private fun computeScore(numbers: List<List<Int>>) = numbers[0]
            .intersect(numbers[1].toSet())
            .count()
            .let { if (it > 0) 2.0.pow(it - 1.0).toInt() else 0 }

        private fun parseNumbers(input: String) = input
            .split("|")
            .map { it.split(" ").filter { it != "" }.map { it.trim().toInt() } }
    }

}

fun main() {
    Day04().run()
}
