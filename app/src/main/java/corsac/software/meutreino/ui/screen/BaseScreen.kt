package corsac.software.meutreino.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import corsac.software.meutreino.R
import corsac.software.meutreino.ext.colors
import corsac.software.meutreino.ui.theme.MeuTreinoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(modifier: Modifier,
               verticalArrangement: Arrangement.Vertical = Arrangement.Top,
               floatingActionButton: @Composable (() -> Unit) = {},
               content: @Composable () -> Unit,
               ) {
    MeuTreinoTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(stringResource(id = R.string.app_name)) },
                    colors = centerAlignedTopAppBarColors(
                        containerColor = colors().primaryContainer,
                        titleContentColor = colors().onPrimaryContainer,
                    ),
                )
            },
            floatingActionButton = floatingActionButton,
        ) {
            Column(modifier = modifier.padding(it), verticalArrangement = verticalArrangement) {
                content()
            }
        }
    }
}