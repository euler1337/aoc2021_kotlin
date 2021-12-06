import java.io.File
import kotlin.streams.toList

class Day2 {

    private val fileName: String = "/Users/mican/src/aoc2021_kotlin/src/main/resources/day2.txt"

    fun a() {
        val input: List<Pair<String, Int>> = File(fileName).readLines()
            .map(this::parswRow)

        val xPos = input.stream()
            .filter { (command, _)  -> command == "forward" }
            .map { (_, distance) -> distance}
            .reduce(Integer::sum)

        val zPos = input.stream()
            .filter { (command, _)  -> (command == "up") || (command == "down") }
            .map { (command, distance) -> if (command == "down") distance else -distance }
            .reduce(Integer::sum)

        print(xPos.get() * zPos.get())
    }

    fun parswRow(raw : String): Pair<String, Int> {
        val list : List<String> = raw.split(" ")
        return Pair(list[0], list[1].toInt())
    }

    fun b() {

    }
}