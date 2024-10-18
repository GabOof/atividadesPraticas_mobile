fun main() {
    // Variáveis para armazenar a soma das idades e o número total de pessoas
    var totalIdade = 0
    var totalPessoas = 0

    // Loop principal que continua até que o usuário decida encerrar a contagem de idades
    while (true) {
        println("Digite o número de pessoas na casa (ou -1 para encerrar a contagem):")
        // Lê o número de pessoas na casa e converte para inteiro
        val numPessoas = readlnOrNull()?.toIntOrNull()

        // Verifica se a entrada é válida
        if (numPessoas == null || numPessoas < -1) {
            println("Número inválido. Tente novamente.")
            continue
        }

        // Condição de parada do loop caso o usuário decida encerrar a contagem
        if (numPessoas == -1) {
            break
        }

        // Loop para ler a idade de cada pessoa na casa
        var i = 1
        while (i <= numPessoas) {
            println("Digite a idade da pessoa $i:")
            // Lê a idade da pessoa e converte para inteiro
            val idade = readlnOrNull()?.toIntOrNull()

            // Verifica se a idade é válida
            if (idade == null || idade < 0) {
                println("Idade inválida. Tente novamente.")
                continue
            }

            // Adiciona a idade ao total e incrementa o número de pessoas
            totalIdade += idade
            totalPessoas++
            i++
        }
    }

    // Calcula e imprime a média de idade se houver pessoas
    if (totalPessoas > 0) {
        val mediaIdade = totalIdade.toDouble() / totalPessoas
        println("A média de idade dos residentes do vilarejo é: %.2f".format(mediaIdade))
    } else {
        println("Nenhuma idade foi informada.")
    }
}