package corsac.software.meutreino.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import corsac.software.meutreino.R
import corsac.software.meutreino.etc.ext.colors
import corsac.software.meutreino.presentation.HomeViewModel
import corsac.software.meutreino.treino.ExercicioTreino
import corsac.software.meutreino.treino.Treino
import corsac.software.meutreino.ui.component.BaseScreenLayout
import corsac.software.meutreino.ui.component.CardTreino
import org.koin.androidx.compose.koinViewModel

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<HomeViewModel>()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            viewModel.iniciarBuscaTreinos()
        }

        val treinos = viewModel.treinos.value

        HomeScreenLayout(
            onClickFab = { navigator.push(CriacaoTreinoScreen()) },
            treinos = treinos
        )
    }
}

@Composable
private fun HomeScreenLayout(
    onClickFab: () -> Unit,
    treinos: Map<Treino, List<ExercicioTreino>>?,
) {
    BaseScreenLayout(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = onClickFab) {
                Icon(
                  imageVector = Icons.Filled.Add,
                  contentDescription = stringResource(R.string.acessibilidade_adicionar_treino)
                )
            }
        },
        topBar = { TopBar() }
    ) {
        if (treinos.isNullOrEmpty()) {
            Text(
                text = stringResource(R.string.placeholder_nenhum_treino),
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center
            )
        } else {
            treinos.forEach { (treino, listaExercicios) ->
                CardTreino(treino, listaExercicios.size)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colors().primaryContainer,
            titleContentColor = colors().onPrimaryContainer,
        ),
    )
}