fun main() {
  println(5.mais(3))
  println(5 mais 3)
}

infix fun Int.mais(n: Int): Int {
  return this + n
}
