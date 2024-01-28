package corsac.software.meutreino.treino

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
class Carga(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val idExercicioTreino: Long,
    val valor: Int,
    val data: LocalDate = LocalDate.now(),
)