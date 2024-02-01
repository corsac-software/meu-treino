package corsac.software.meutreino.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import corsac.software.meutreino.R
import corsac.software.meutreino.etc.ext.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarBasica(
    titulo: String,
    backIcon: @Composable () -> Unit,
    onClickBack: () -> Unit,
) {
    TopAppBar(
        title = { Text(titulo) },
        navigationIcon = {
            IconButton(
                onClick = onClickBack,
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.a11y_botao_voltar),
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colors().primaryContainer,
            titleContentColor = colors().onPrimaryContainer,
        )
    )
}