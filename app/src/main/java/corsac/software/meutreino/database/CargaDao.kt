package corsac.software.meutreino.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import corsac.software.meutreino.treino.Carga

@Dao
interface CargaDao {
    @Query("SELECT * FROM carga WHERE idExercicioTreino = :idExercicioTreino")
    suspend fun listarPorIdExercicioTreino(idExercicioTreino: Long): List<Carga>

    @Insert
    suspend fun inserir(treino: Carga): Long

    @Delete
    suspend fun deletar(treino: Carga)
}