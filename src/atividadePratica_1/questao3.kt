fun main() {
    println("Jogador 1, digite sua jogada (pedra, papel ou tesoura):")
    // Lê a jogada do Jogador 1 e converte para minúsculas
    val jogada1 = readlnOrNull()?.lowercase() ?: return

    println("Jogador 2, digite sua jogada (pedra, papel ou tesoura):")
    // Lê a jogada do Jogador 2 e converte para minúsculas
    val jogada2 = readlnOrNull()?.lowercase() ?: return

    // Determina o resultado do jogo chamando a função determinarVencedor
    val resultado = determinarVencedor(jogada1, jogada2)
    println(resultado)
}

fun determinarVencedor(jogada1: String, jogada2: String): String {
    // Verifica se as jogadas são iguais, resultando em empate
    return if (jogada1 == jogada2) {
        "Empate"
    }
    // Verifica todas as possibilidades de vitória do Jogador 1
    else if ((jogada1 == "pedra" && jogada2 == "tesoura") ||
        (jogada1 == "papel" && jogada2 == "pedra") ||
        (jogada1 == "tesoura" && jogada2 == "papel")
    ) {
        "Jogador 1 venceu"
    }
    // Verifica todas as possibilidades de vitória do Jogador 2
    else if ((jogada2 == "pedra" && jogada1 == "tesoura") ||
        (jogada2 == "papel" && jogada1 == "pedra") ||
        (jogada2 == "tesoura" && jogada1 == "papel")
    ) {
        "Jogador 2 venceu"
    }
    // Caso as jogadas não sejam válidas
    else {
        "Jogada inválida"
    }
}