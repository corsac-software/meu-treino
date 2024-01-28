package corsac.software.meutreino.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import corsac.software.meutreino.treino.Carga
import corsac.software.meutreino.treino.Exercicio
import corsac.software.meutreino.treino.ExercicioTreino
import corsac.software.meutreino.treino.Treino

@Database(version = 1, entities = [
    Exercicio::class, ExercicioTreino::class, Carga::class, Treino::class,
])
@TypeConverters(Converters::class)
abstract class MeuTreinoDatabase : RoomDatabase() {
    abstract fun exercicioDao(): ExercicioDao
    abstract fun treinoDao(): TreinoDao
    abstract fun exercicioTreinoDao(): ExercicioTreinoDao
    abstract fun cargaDao(): CargaDao
}