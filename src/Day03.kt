import common.Day

typealias Matrix = List<List<Char>>
typealias Number = Pair<Coordinates, String>

data class Coordinates(val x: Int, val y: Int)

class Day03 : Day("03") {

    override fun part1(input: List<String>): Int {
        val matrix = getMatrix(input)
        return getNumbersAndStars(matrix).first
            .filter { nb ->
                neighbours(matrix, nb)
                    .any {
                        val c = matrix[it.y][it.x]
                        !c.isDigit() && c != '.'
                    }
            }
            .sumOf { it.second.toInt() }
    }

    override fun part2(input: List<String>): Int {
        val matrix = getMatrix(input)
        val (numbers, stars) = getNumbersAndStars(matrix)
        return stars
            .associateWith { star ->
                numbers.filter { nb ->
                    neighbours(matrix, nb).any { it == star }
                }
            }
            .filter { it.value.size == 2 }
            .values
            .sumOf { it.map { nb -> nb.second.toInt() }.reduce(Int::times) }
    }

    companion object {
        private fun getMatrix(input: List<String>) = input.map { it.toList() }

        private fun getNumbersAndStars(matrix: Matrix):
                Pair<MutableList<Number>, MutableList<Coordinates>> {

            val numbers = mutableListOf<Number>()
            val stars = mutableListOf<Coordinates>()
            for (y in matrix.indices) {
                var x = 0
                while (x < matrix[y].size) {
                    val cell = matrix[y][x]
                    if (cell.isDigit()) {
                        var xCursor = x
                        var nb = ""
                        while (xCursor < matrix[y].size && matrix[y][xCursor].isDigit()) {
                            nb += matrix[y][xCursor]
                            xCursor++
                        }
                        numbers.add(Coordinates(x, y) to nb)
                        x = xCursor
                    } else if (cell == '*') {
                        stars.add(Coordinates(x, y))
                        x++
                    } else {
                        x++
                    }
                }
            }
            return numbers to stars
        }

        private fun neighbours(matrix: Matrix, nb: Number): List<Coordinates> {
            val xRange = nb.first.x - 1..nb.first.x + nb.second.length
            val yRange = nb.first.y - 1..nb.first.y + 1
            return yRange
                .map { y -> xRange.map { x -> Coordinates(x, y) } }
                .flatten()
                .filter { it.x in matrix[0].indices && it.y in matrix.indices }
        }
    }

}

fun main() {
    Day03().run()
}
