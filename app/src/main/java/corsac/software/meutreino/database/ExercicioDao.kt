package corsac.software.meutreino.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import corsac.software.meutreino.treino.Exercicio

@Dao
interface ExercicioDao {
    @Query("SELECT * FROM exercicio")
    fun getAll(): List<Exercicio>

    @Query("SELECT * FROM exercicio WHERE id = :id")
    fun getById(id: Int): Exercicio?

    @Insert
    fun insert(exercicio: Exercicio): Long

    @Update
    fun update(exercicio: Exercicio)

    @Delete
    fun delete(exercicio: Exercicio)
}