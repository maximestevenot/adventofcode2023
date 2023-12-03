import common.Day

class Day02 : Day("02") {
    override fun part1(input: List<String>): Int {
        return parseGames(input)
            .map { it.first to parseResults(it.second) }
            .filter { game -> game.second.all { isSetPossible(it) } }
            .sumOf { it.first }
    }

    override fun part2(input: List<String>): Int {
        return parseGames(input)
            .map { game ->
                game.first to toPairs(game.second.split(",", ";"))
                    .groupBy { it.first }
                    .map { it.value.maxBy { it.second } }
                    .map { it.second }.reduce(Int::times)
            }
            .map { it.second }
            .reduce(Int::plus)
    }

    companion object {
        private fun parseGames(input: List<String>) = input
            .map { it.split(":") }
            .map { it[0].replace("Game", "").trim().toInt() to it[1].trim() }

        private fun parseResults(results: String) = results
            .split(";")
            .map { toPairs(it.split(",")) }

        private fun toPairs(input: List<String>) = input
            .map { it.trim().split(" ") }
            .map { it[1] to it[0].toInt() }

        private fun isSetPossible(set: List<Pair<String, Int>>): Boolean {
            return set.all {
                when (it.first) {
                    "red" -> it.second <= 12
                    "green" -> it.second <= 13
                    "blue" -> it.second <= 14
                    else -> throw Exception("Unknown color")
                }
            }
        }
    }

}

fun main() {
    Day02().run()
}
