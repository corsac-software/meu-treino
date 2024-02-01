
package corsac.software.meutreino.ui.screen

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import corsac.software.meutreino.R
import corsac.software.meutreino.treino.GrupoMuscular
import corsac.software.meutreino.ui.component.AppBarBasica
import corsac.software.meutreino.ui.component.AutoCompleteInput
import corsac.software.meutreino.ui.component.BaseScreenLayout
import corsac.software.meutreino.ui.component.BotaoCarregamento
import corsac.software.meutreino.ui.component.CardExercicio
import corsac.software.meutreino.ui.component.CardNovoExercicio
import corsac.software.meutreino.ui.component.IconBotaoVoltar
import corsac.software.meutreino.ui.component.OutlinedSelector

class CriacaoTreinoScreen : Screen {
    internal data class State(
        var nomeTreino: String = "",
        val grupoMuscular: GrupoMuscular? = null,
        val descricaoCustomizada: String? = null,
    )

    @Composable
    override fun Content() {
        val data = remember { mutableStateOf(State()) }
        val navigator = LocalNavigator.currentOrThrow

        CriacaoTreinoLayout(
            data = data,
            onSubmit = { },
            onClickBack = { navigator.pop() }
        )
    }
}

@Composable
private fun CriacaoTreinoLayout(
    data: MutableState<CriacaoTreinoScreen.State>,
    isCadastrando: Boolean = false,
    onSubmit: () -> Unit = {},
    onClickBack: () -> Unit,
) {
    var state by remember { mutableIntStateOf(0) }
    val scrollState = rememberScrollState()

    BaseScreenLayout(
        modifier = Modifier.fillMaxHeight(),
        topBar = {
            AppBarBasica(
                titulo = stringResource(R.string.titulo_criando_novo_treino),
                backIcon = { IconBotaoVoltar() },
                onClickBack = onClickBack
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(modifier = Modifier
                .padding(vertical = 8.dp)
                .verticalScroll(scrollState)) {
                InputNomeTreino(data = data)

                SelectorGrupoMuscular(data = data)

                Divider(modifier = Modifier
                    .padding(vertical = 8.dp)
                    .height(1.dp)
                    .fillMaxWidth())

                Column {
                    for(i in 0 until state) {
                        CardExercicio(
                            nome = "Exercício $i",
                            series = 3,
                            repeticoes = 10,
                            carga = 20
                        )

                        Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    }

                    CardNovoExercicio {
                        state++
                    }
                }
            }


            BotaoCarregamento(
                modifier = Modifier.padding(8.dp),
                text = {
                    Text(
                        fontSize = 16.sp,
                        text = stringResource(R.string.label_botao_cadastrar)
                    )
                },
                isCarregando = isCadastrando,
                onClick = onSubmit
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputNomeTreino(
    data: MutableState<CriacaoTreinoScreen.State>,
) {
    val (nomeTreino) = data.value
    val inputInteractionSource = remember { MutableInteractionSource() }
    val isInputFocused = inputInteractionSource.collectIsFocusedAsState() as MutableState<Boolean>
    val sugestoesAutoComplete = listOf(
        stringResource(id = R.string.sugestao_treino_a),
        stringResource(id = R.string.sugestao_treino_b),
        stringResource(id = R.string.sugestao_treino_c),
    )
    val ignorarSugestoes = remember { mutableStateOf(false) }

    AutoCompleteInput(
        modifier = Modifier.fillMaxWidth(),
        textField = {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.label_nome_treino)) },
                placeholder = { Text(stringResource(R.string.placeholder_input_nome_treino)) },
                value = TextFieldValue(text = nomeTreino, selection = TextRange(nomeTreino.length)),
                onValueChange = {
                    data.value = data.value.copy(nomeTreino = it.text)

                    if(it.text.isEmpty()) {
                        ignorarSugestoes.value = false
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text,
                ),
                interactionSource = inputInteractionSource,
            )
        },
        exibirSugestoes = !ignorarSugestoes.value && isInputFocused.value && nomeTreino.isEmpty(),
        opcoes = sugestoesAutoComplete,
        onSelect = { data.value = data.value.copy(nomeTreino = it) },
        onDismiss = { ignorarSugestoes.value = true }
    )
}

@Composable
private fun SelectorGrupoMuscular(
    data: MutableState<CriacaoTreinoScreen.State>
) {
    val opcoes = GrupoMuscular.entries
        .filterNot { it.resourceNomeExibicao == null }
        .associate { (stringResource(it.resourceNomeExibicao!!) to it) }

    OutlinedSelector(
        opcoes = opcoes.keys.toList(),
        selected = data.value.grupoMuscular?.resourceNomeExibicao?.let { stringResource(it) } ?: "",
        onSelect = { data.value = data.value.copy(grupoMuscular = opcoes[it]) }
    )
}

@Preview
@Composable
private fun CriacaoTreinoScreenPreview() {
    val state = remember { mutableStateOf(CriacaoTreinoScreen.State()) }
    var isCadastrando by remember { mutableStateOf(false) }

    CriacaoTreinoLayout(state, isCadastrando) { isCadastrando = !isCadastrando }
}