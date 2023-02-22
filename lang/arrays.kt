fun main() {
  var vetor = Array(5) { i -> (i * i).toString() }

  var outroVetor = arrayOf("1", 2, '3', 4.0, 5.0f, 6L)

  outroVetor[0] = 7.0
  println(outroVetor[0]) // resultado: 7.0
}
