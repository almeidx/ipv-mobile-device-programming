fun main() {
  multiprint("a", "b", "c")

  val a = arrayOf("c", "d", "e")
  multiprint("a", "b", *a, "f")
}

fun multiprint(vararg strings: String): Unit {
  for (string in strings) print(string + " ")
  println()
}
