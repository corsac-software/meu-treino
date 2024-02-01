package corsac.software.meutreino.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import corsac.software.meutreino.ui.theme.MeuTreinoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreenLayout(
    modifier: Modifier = Modifier,
    topBar: @Composable (() -> Unit) = {},
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    floatingActionButton: @Composable (() -> Unit) = {},
    content: @Composable () -> Unit,
) {
    MeuTreinoTheme {
        Scaffold(
            topBar = topBar,
            floatingActionButton = floatingActionButton,
        ) {
            Column(
                modifier = modifier.padding(it).padding(8.dp),
                verticalArrangement = verticalArrangement) {
                content()
            }
        }
    }
}