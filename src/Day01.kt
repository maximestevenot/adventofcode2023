import common.Day

class Day01 : Day("01") {
    override fun part1(input: List<String>): Int {
        return input
            .map { it.filter { c -> c.isDigit() } }
            .sumOf { "${it.first()}${it.last()}".toInt() }
    }

    override fun part2(input: List<String>): Int {
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

}

fun main() {
    Day01().run()
}
