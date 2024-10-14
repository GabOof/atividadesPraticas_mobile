fun main() {
    println("Digite a hora de início do jogo: (Em número inteiro de 1 a 24)")
    // Lê a entrada do usuário e converte para inteiro, ou retorna se inválido
    val inicio = readlnOrNull()?.toIntOrNull() ?: return

    println("Digite a hora de término do jogo: (Em número inteiro de 1 a 24)")
    // Lê a entrada do usuário e converte para inteiro, ou retorna se inválido
    val fim = readlnOrNull()?.toIntOrNull() ?: return

    // Calcula a duração do jogo
    val duracao = calcularDuracaoJogo(inicio, fim)
    println("O jogo durou $duracao hora(s)")
}

fun calcularDuracaoJogo(inicio: Int, fim: Int): Int {
    var tempoTotal = 0 // Inicializa a variável que armazenará o tempo total do jogo
    var terminaNoDiaSeguinte = false // Variável para verificar se o jogo termina no dia seguinte

    if (fim == inicio) { // Caso onde o jogo iniciou e terminou no mesmo horário
        println("O jogo terminou no dia seguinte? (Digite 's' para sim e 'n' para não)")

        // Lê a entrada do usuário para verificar se o jogo terminou no dia seguinte
        terminaNoDiaSeguinte = readlnOrNull() == "s"

        tempoTotal = if (terminaNoDiaSeguinte) {
            24 // Se terminou no dia seguinte, a duração é de 24 horas
        } else {
            0 // Se não terminou no dia seguinte, a duração é de 0 horas
        }
    } else if (fim > inicio) { // Caso onde o jogo começa e termina no mesmo dia
        tempoTotal = fim - inicio // Calcula a duração subtraindo a hora de início da hora de término
    } else { // Caso onde o jogo começa em um dia e termina no outro dia
        tempoTotal = 24 - inicio + fim // Calcula a duração considerando a passagem para o dia seguinte
    }

    return tempoTotal // Retorna a duração total do jogo
}