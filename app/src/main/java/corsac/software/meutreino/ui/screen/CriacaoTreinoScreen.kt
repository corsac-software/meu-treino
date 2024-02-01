
package corsac.software.meutreino.ui.screen

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import corsac.software.meutreino.R
import corsac.software.meutreino.ui.component.AppBarBasica
import corsac.software.meutreino.ui.component.AutoCompleteInput
import corsac.software.meutreino.ui.component.BaseScreenLayout
import corsac.software.meutreino.ui.component.BotaoCarregamento

class CriacaoTreinoScreen : Screen {
    internal data class State(
        var nomeTreino: String = "",
    )

    @Composable
    override fun Content() {
        val (data, setData) = remember { mutableStateOf(State()) }
        val navigator = LocalNavigator.currentOrThrow

        CriacaoTreinoLayout(
            data = data,
            setData = setData,
            onSubmit = { },
            onClickBack = { navigator.pop() }
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun CriacaoTreinoLayout(
    data: CriacaoTreinoScreen.State,
    setData: (CriacaoTreinoScreen.State) -> Unit,
    isCadastrando: Boolean = false,
    onSubmit: () -> Unit = {},
    onClickBack: () -> Unit,
) {
    BaseScreenLayout(topBar = {
        AppBarBasica(
            titulo = stringResource(R.string.titulo_criando_novo_treino),
            backIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.acessibilidade_botao_voltar)
                )
            },
            onClickBack = onClickBack
        )
    }) {
        InputNomeTreino(data = data, setData = setData)

        BotaoCarregamento(
            text = {
                Text(
                    fontSize = 16.sp,
                    text = stringResource(R.string.botao_cadastrar)
                )
            },
            isCarregando = isCadastrando,
            onClick = onSubmit
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputNomeTreino(
    data: CriacaoTreinoScreen.State,
    setData: (CriacaoTreinoScreen.State) -> Unit,
) {
    val (nomeTreino) = data
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
                    setData(data.copy(nomeTreino = it.text))

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
        onSelect = {
            setData(data.copy(nomeTreino = it))
        },
        onDismiss = {
            ignorarSugestoes.value = true
        }
    )
}

@Preview
@Composable
private fun CriacaoTreinoScreenPreview() {
    val (state, setState) = remember { mutableStateOf(CriacaoTreinoScreen.State()) }
    var isCadastrando by remember { mutableStateOf(false) }

    CriacaoTreinoLayout(state, setState, isCadastrando) { isCadastrando = !isCadastrando }
}