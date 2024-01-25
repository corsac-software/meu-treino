package corsac.software.meutreino.database

import androidx.room.Database
import androidx.room.RoomDatabase
import corsac.software.meutreino.treino.Exercicio

@Database(version = 1, entities = [
    Exercicio::class,
])
abstract class MeuTreinoDatabase : RoomDatabase() {
    abstract fun exercicioDao(): ExercicioDao
}