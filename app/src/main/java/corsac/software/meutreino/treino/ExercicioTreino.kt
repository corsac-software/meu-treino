package corsac.software.meutreino.treino

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ExercicioTreino(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val idTreino: Long,
    val idExercicio: Long,
    val repeticoes: Int,
    val series: Int
)