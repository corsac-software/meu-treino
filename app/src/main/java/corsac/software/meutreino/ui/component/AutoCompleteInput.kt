package corsac.software.meutreino.ui.component

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AutoCompleteInput(
    modifier: Modifier = Modifier,
    textField: @Composable () -> Unit,
    exibirSugestoes: Boolean,
    opcoes: List<String>,
    onSelect: (String) -> Unit,
    onDismiss: () -> Unit,
) {
    BoxWithConstraints {
        val textFieldWidth = this.maxWidth
        Column(modifier) {
            textField()

            DropdownMenu(
                modifier = Modifier.width(textFieldWidth),
                expanded = exibirSugestoes,
                onDismissRequest = onDismiss,
            ) {
                opcoes.forEach {
                    DropdownMenuItem(
                        text = { Text(it) },
                        onClick = { onSelect(it) }
                    )
                }
            }
        }
    }
}