fun main() {
    val saldoTotal = 80 // Define o saldo total disponível
    val notasDez = 2 // Define a quantidade de notas de R$ 10,00 disponíveis
    val notasCinco = 10 // Define a quantidade de notas de R$ 5,00 disponíveis
    val notasUm = 10 // Define a quantidade de notas de R$ 1,00 disponíveis

    println("Digite o valor da compra:")
    // Lê o valor da compra digitado pelo usuário e converte para inteiro, ou define como 0 se a entrada for inválida
    val valorCompra = readlnOrNull()?.toIntOrNull() ?: 0

    // Verifica se o valor da compra é maior que o saldo total disponível
    if (valorCompra > saldoTotal) {
        // Exibe uma mensagem de erro se o valor da compra for superior ao saldo total
        println("Erro: O valor da compra é superior a R$ 80,00.")
    } else {
        // Inicializa o saldo restante com o valor da compra
        var saldoRestante = valorCompra

        // Calcula a quantidade de notas de R$ 10,00 que serão usadas, sem exceder a quantidade disponível
        val notasDezUsadas = minOf(saldoRestante / 10, notasDez)
        // Subtrai do saldo restante o valor correspondente às notas de R$ 10,00 usadas
        saldoRestante -= notasDezUsadas * 10

        // Calcula a quantidade de notas de R$ 5,00 que serão usadas, sem exceder a quantidade disponível
        val notasCincoUsadas = minOf(saldoRestante / 5, notasCinco)
        // Subtrai do saldo restante o valor correspondente às notas de R$ 5,00 usadas
        saldoRestante -= notasCincoUsadas * 5

        // Calcula a quantidade de notas de R$ 1,00 que serão usadas, sem exceder a quantidade disponível
        val notasUmUsadas = minOf(saldoRestante, notasUm)
        // Subtrai do saldo restante o valor correspondente às notas de R$ 1,00 usadas
        saldoRestante -= notasUmUsadas

        println("Quantidade de notas de R$ 10,00: $notasDezUsadas")
        println("Quantidade de notas de R$ 5,00: $notasCincoUsadas")
        println("Quantidade de notas de R$ 1,00: $notasUmUsadas")
    }
}