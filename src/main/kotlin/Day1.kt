import java.io.File

class Day1 {

    private val fileName: String = "/Users/mican/src/aoc2021_kotlin/src/main/resources/day1.txt"

    fun a() {
        val input: List<Int> = File(fileName).readLines().map(String::toInt)
        val count = input
            .windowed(2,1)
            .filter { i ->i.get(0) < i.get(1) }.count()
        print("1a: $count \n")
    }

    fun b() {
        val input: List<Int> = File(fileName).readLines().map(String::toInt)
        val count = input.windowed(3,1)
            .map{c -> c.sum() }
            .windowed(2,1)
            .filter { i ->i.get(0) < i.get(1) }.count()
        print("1b: $count \n")
    }
}