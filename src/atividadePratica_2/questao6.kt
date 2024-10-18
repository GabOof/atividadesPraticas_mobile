fun main() {
    // Inicializa variáveis para armazenar o maior e o segundo maior número
    var maior = Int.MIN_VALUE
    var segundoMaior = Int.MIN_VALUE

    // Loop para ler 20 números inteiros do usuário
    for (i in 1..20) {
        println("Digite o $i" + "º número:")
        val num = readlnOrNull()?.toIntOrNull() ?: continue

        // Atualiza o maior e o segundo maior número com base na entrada
        if (num > maior) {
            segundoMaior = maior
            maior = num
        } else if (num > segundoMaior) {
            segundoMaior = num
        }
    }

    // Imprime o maior e o segundo maior número
    println("O maior número é: $maior")
    println("O segundo maior número é: $segundoMaior")
}