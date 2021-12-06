import java.io.File

class Day2 {

    private val fileName: String = "/Users/mican/src/aoc2021_kotlin/src/main/resources/day2.txt"

    fun a() {
        val input: List<Pair<String, Int>> = File(fileName).readLines()
            .map(this::parseRow)

        val xPos = input.stream()
            .filter { (command, _)  -> command == "forward" }
            .map { (_, distance) -> distance}
            .reduce(Integer::sum)

        val zPos = input.stream()
            .filter { (command, _)  -> (command == "up") || (command == "down") }
            .map { (command, distance) -> if (command == "down") distance else -distance }
            .reduce(Integer::sum)

        print("2a: ${xPos.get() * zPos.get()} \n")
    }

    fun parseRow(raw : String): Pair<String, Int> {
        val list : List<String> = raw.split(" ")
        return Pair(list[0], list[1].toInt())
    }

    fun b() {
        val input: List<Pair<String, Int>> = File(fileName).readLines()
            .map(this::parseRow)

        var aim = 0; var xPos = 0; var zPos = 0
        for (row in input) {
            when (row.first) {
                "forward" -> {
                    xPos += row.second
                    zPos += row.second * aim
                }
                "down" -> {
                    aim += row.second
                }
                "up" -> {
                    aim -= row.second
                }
            }
        }
        print("2b: ${xPos * zPos} \n")
    }
}