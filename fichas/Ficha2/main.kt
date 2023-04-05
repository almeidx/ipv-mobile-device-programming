fun main() {
    println(" 0 ∈ [ 0, 10]: ${inRange( 0, Pair( 0, 10))}")
    println("15 ∈ [11, 20]: ${inRange(15, Pair(11, 20))}")
    println("35 ∈ [21, 30]: ${inRange(35, Pair(21, 30))}")
    println("39 ∈ [31, 40]: ${inRange(39, Pair(31, 40))}")

    println("∑[0, 5] = ${sum(0, 5)}")

    val n = Number()

    println("∑[0, 10] (Pares) = ${n.sumEvenBetween(0, 10)}")
}

// Exercício 1
fun inRange(x: Int, range: Pair<Int, Int>): Boolean {
    val (a, b) = range
    return x >= a && x <= b
}

// Exercício 2
fun sum(a: Int, b: Int): Int {
    if (a >= b) {
        return 0
    }

    var sum: Int = 0
    for (i in a..b) {
        sum += i
    }

    return sum
}

// Exercício 3
class Number {
    fun sumEvenBetween(a: Int, b: Int): Int {
        if (a >= b) {
            return 0
        }

        // Caso o número inicial for ímpar
        val start = if (a % 2 == 0) a else a + 1
        var sum: Int = 0

        for (i in start..b step 2) {
            sum += i
        }

        return sum
    }
}
