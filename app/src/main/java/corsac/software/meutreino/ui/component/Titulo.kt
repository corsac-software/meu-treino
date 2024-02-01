package corsac.software.meutreino.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import corsac.software.meutreino.ui.screen.BaseScreen

@Composable
fun Titulo(valor: String) {
    Text(
        valor,
        style = MaterialTheme.typography.titleLarge,
        textAlign = Center
    )
}

@Preview
@Composable
fun TituloPreview() {
    BaseScreen {
        Titulo("Exemplo de título")
    }
}