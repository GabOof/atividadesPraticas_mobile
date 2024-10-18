// COMENTÁRIOS DA QUESTÃO

// A questão menciona que o ciclista retorna ao ponto de término da prova (mesma altitude que a primeira registrada),
// mas não especifica claramente se devemos contabilizar essa subida.
//
// Decidi considerar que o retorno ao ponto inicial deve contar como uma subida, caso o ciclista termine a prova em uma
// altitude inferior à inicial e precise subir para retornar ao início. Para isso, adicionei uma comparação entre a
// última altitude registrada e a primeira. Se a altitude final for menor que a inicial, é somado mais 250 metros à
// distância de subida, pois o ciclista teria subido para voltar ao ponto de partida.

// Exemplo:
// Se o ciclista percorreu 1.000 metros e registrou as altitudes 30 (0m), 20 (250m), 10 (500m) e 0 (750m) metros, a
// distância total subindo seria de 250 metros (250 metros entre o ponto 750m e o final da prova em 1.000m). Se a última
// altitude registrada fosse 20 metros ou invés de 0 metros, a distância total subindo seria de 500 metros (250 metros
// para subir do 3º ponto ao 4º ponto e 250 metros para subir do 4º ponto ao final da prova - 1.000m).

fun main() {
    // Receber a distância total percorrida
    print("Informe a distância total percorrida (em metros): ")
    val distanciaTotal = readln().toInt()

    // Calcular o número de altitudes (a cada 250 metros)
    val numAltitudes = distanciaTotal / 250
    println("A prova tem um total de $numAltitudes pontos de medição de altitude.")

    // Receber as altitudes anotadas
    println("Por favor, insira as altitudes registradas (uma por vez):")
    val altitudes = mutableListOf<Int>()
    for (i in 1..numAltitudes) {
        print("Altitude no ponto ${i} (em metros): ")
        val altitude = readln().toInt()
        altitudes.add(altitude)
    }

    // Variável para armazenar a distância total subindo
    var distanciaSubindo = 0

    // Calcular a distância total subindo
    for (i in 0 until altitudes.size - 1) {
        if (altitudes[i + 1] > altitudes[i]) {
            distanciaSubindo += 250
        }
    }

    // Comparar a última altitude com a primeira para considerar o retorno
    if (altitudes.last() < altitudes.first()) {
        distanciaSubindo += 250
    }

    // Exibir o resultado final de forma clara
    println("A distância total percorrida subindo foi de: $distanciaSubindo metros")
}
