fun main() {
    fun part1(input: List<String>): Long {
        return input
            .map { it.filter { c -> c.isDigit() } }
            .sumOf { "${it.first()}${it.last()}".toLong() }
    }

    fun part2(input: List<String>): Int {
        return input.map { string ->
            string.windowed(5, 1, true) {
                when {
                    it.first().isDigit() -> it.first().toString()
                    it.startsWith("zero") -> "0"
                    it.startsWith("one") -> "1"
                    it.startsWith("two") -> "2"
                    it.startsWith("three") -> "3"
                    it.startsWith("four") -> "4"
                    it.startsWith("five") -> "5"
                    it.startsWith("six") -> "6"
                    it.startsWith("seven") -> "7"
                    it.startsWith("eight") -> "8"
                    it.startsWith("nine") -> "9"
                    else -> ""
                }
            }.filter { it.isNotEmpty() }
        }.sumOf { "${it.first()}${it.last()}".toInt() }
    }

    val input = readInput("Day01")
    part1(input).println()
    "----".println()
    part2(input).println()
}
