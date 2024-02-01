package corsac.software.meutreino.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import corsac.software.meutreino.treino.ExercicioTreino

@Dao
interface ExercicioTreinoDao {
    @Query("SELECT * FROM ExercicioTreino WHERE idTreino = :idTreino")
    suspend fun listarPorIdTreino(idTreino: Long): List<ExercicioTreino>

    @Query("SELECT * FROM ExercicioTreino WHERE id = :id")
    suspend fun buscarPorId(id: Int): ExercicioTreino?

    @Insert
    suspend fun inserir(exercicioTreino: ExercicioTreino): Long

    @Update
    suspend fun atualizar(exercicioTreino: ExercicioTreino)

    @Delete
    suspend fun deletar(exercicioTreino: ExercicioTreino)
}