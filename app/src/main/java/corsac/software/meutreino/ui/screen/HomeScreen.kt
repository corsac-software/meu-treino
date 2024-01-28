package corsac.software.meutreino.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import corsac.software.meutreino.presentation.HomeViewModel
import corsac.software.meutreino.ui.component.CardExercicio
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.iniciarBuscaTreinos()
    }

    val treinos = viewModel.treinos.value

    BaseScreen(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, contentDescription = "Adicionar treino")
            }
        }
    ) {
        if(treinos.isNullOrEmpty()) {
            Text(
                text = "Nenhum treino cadastrado.\nClique no botão \"+\" para adicionar um novo treino.",
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        } else {
            treinos.forEach {
                (key, _) -> CardExercicio(key, viewModel.quantidadeDeExercicios(key))
            }
        }
    }
}