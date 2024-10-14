fun main() {
    println("Digite o número do CPF:")
    // Lê a entrada do usuário, filtra apenas os dígitos e armazena na variável 'cpf'
    val cpf = readlnOrNull()?.filter { it.isDigit() } ?: return

    // Verifica se o CPF é válido e imprime a mensagem correspondente
    if (verificaCPF(cpf)) {
        println("CPF válido")
    } else {
        println("CPF inválido")
    }
}

// Função que verifica se um CPF é válido
fun verificaCPF(cpf: String): Boolean {
    // Verifica se o CPF tem exatamente 11 dígitos
    if (cpf.length != 11) return false

    // Verifica se todos os dígitos do CPF são iguais
    if (cpf.all { it == cpf[0] }) return false

    // Calcula o primeiro dígito verificador
    val primeiroDigito = calculaDigito(cpf.substring(0, 9))

    // Calcula o segundo dígito verificador
    val segundoDigito = calculaDigito(cpf.substring(0, 9) + primeiroDigito)

    // Verifica se os dígitos verificadores calculados correspondem aos dígitos do CPF
    return cpf.endsWith("$primeiroDigito$segundoDigito")
}

// Função que calcula um dígito verificador do CPF
fun calculaDigito(cpf: String): Int {
    // Define os pesos a serem usados no cálculo, dependendo do comprimento do CPF
    val pesos = if (cpf.length == 9) (10 downTo 2) else (11 downTo 2)
    // Calcula a soma ponderada dos dígitos do CPF
    val soma = cpf.map { it.toString().toInt() }
        .zip(pesos) { digito, peso -> digito * peso }
        .sum()

    // Calcula o resto da divisão da soma por 11
    val restante = soma % 11
    // Retorna o dígito verificador, que é 0 se o resto for menor que 2, ou 11 menos o resto
    return if (restante < 2) 0 else 11 - restante
}