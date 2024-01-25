package corsac.software.meutreino

import android.app.Application
import corsac.software.meutreino.etc.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MeuTreinoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MeuTreinoApplication)
            modules(appModule)
        }
    }
}