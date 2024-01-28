package corsac.software.meutreino.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import corsac.software.meutreino.treino.Exercicio

@Dao
interface ExercicioDao {
    @Query("SELECT * FROM exercicio")
    suspend fun listar(): List<Exercicio>

    @Query("SELECT * FROM exercicio WHERE id = :id")
    suspend fun buscarPorId(id: Int): Exercicio?

    @Insert
    suspend fun inserir(exercicio: Exercicio): Long

    @Insert
    suspend fun inserirTodos(exercicios: List<Exercicio>)

    @Update
    suspend fun atualizar(exercicio: Exercicio)

    @Delete
    suspend fun deletar(exercicio: Exercicio)
}