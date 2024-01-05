package corsac.software.meutreino.treino

import java.time.LocalDate
import java.util.UUID

class Carga(
    val id: UUID = UUID.randomUUID(),
    val valor: Int,
    val data: LocalDate,
)