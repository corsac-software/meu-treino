package corsac.software.meutreino.etc.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import corsac.software.meutreino.database.ExercicioDao
import corsac.software.meutreino.database.MeuTreinoDatabase
import corsac.software.meutreino.presentation.HomeViewModel
import corsac.software.meutreino.treino.Exercicio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(androidContext(), MeuTreinoDatabase::class.java, "MeuTreino.db")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)

                    val exercicioDao: ExercicioDao = get()
                    val exerciciosPadroes = Exercicio.Padroes.entries.map { it.instancia }

                    val scope = CoroutineScope(Dispatchers.IO)

                    scope.launch {
                        exercicioDao.inserirTodos(exerciciosPadroes)
                    }
                }
            })
            .build()
    }
    single { get<MeuTreinoDatabase>().exercicioDao() }
    single { get<MeuTreinoDatabase>().treinoDao() }
    single { get<MeuTreinoDatabase>().exercicioTreinoDao() }
    single { get<MeuTreinoDatabase>().cargaDao() }

    viewModel { HomeViewModel(get()) }
}