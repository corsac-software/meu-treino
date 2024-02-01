package corsac.software.meutreino.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import corsac.software.meutreino.treino.ExercicioTreino
import corsac.software.meutreino.treino.Treino

@Dao
interface TreinoDao {
    @Query("SELECT * FROM treino")
    suspend fun listar(): List<Treino>

    @Query("SELECT * FROM treino JOIN ExercicioTreino ON treino.id = ExercicioTreino.idTreino")
    suspend fun listarComExercicios(): Map<Treino, List<ExercicioTreino>>

    @Insert
    suspend fun inserir(treino: Treino): Long

    @Update
    suspend fun atualizar(treino: Treino)

    @Delete
    suspend fun deletar(treino: Treino)
}