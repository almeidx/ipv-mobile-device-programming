import java.util.Random

fun main() {
  println(choose(5, "7.5", '9'))
}

fun <T> choose(t1: T, t2: T, t3: T): T {
  return when (Random().nextInt(3)) {
    0 -> t1
    1 -> t2
    else -> t3
  }
}
