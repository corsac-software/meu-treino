package corsac.software.meutreino.treino

import java.time.LocalDate
import java.util.UUID

class ExercicioTreino(
    val id: UUID = UUID.randomUUID(),
    val exercicio: Exercicio,
    val repeticoes: Int,
    val series: Int,
    val historicoCargas: Set<Carga>
) {
    fun getCargaAtual() = historicoCargas.maxByOrNull { it.data } ?: Carga(valor = 0, data = LocalDate.now())
}