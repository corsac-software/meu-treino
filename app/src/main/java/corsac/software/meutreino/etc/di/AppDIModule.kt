package corsac.software.meutreino.etc.di

import androidx.room.Room
import corsac.software.meutreino.database.MeuTreinoDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { Room.databaseBuilder(androidContext(), MeuTreinoDatabase::class.java, "meutreino").build() }
    single { get<MeuTreinoDatabase>().exercicioDao() }
}