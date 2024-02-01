package corsac.software.meutreino

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import corsac.software.meutreino.ui.screen.HomeScreen
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun App() {
    KoinAndroidContext {
        Navigator(HomeScreen())
    }
}