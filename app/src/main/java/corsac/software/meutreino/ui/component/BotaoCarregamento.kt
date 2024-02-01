package corsac.software.meutreino.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import corsac.software.meutreino.etc.ext.colors

@Composable
fun BotaoCarregamento(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    isCarregando: Boolean,
    onClick: () -> Unit
) {
    var buttonSize by remember { mutableStateOf(DpSize.Zero) }
    val density = LocalDensity.current

    Button(
        modifier = modifier
            .then(
                if (buttonSize != DpSize.Zero) Modifier.size(buttonSize) else Modifier
            )
            .onSizeChanged { newSize ->
                if (buttonSize == DpSize.Zero) {
                    buttonSize = with(density) {
                        newSize.toSize().toDpSize()
                    }
                }
            }
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = MaterialTheme.shapes.small,
    ) {
        if(isCarregando) {
            CircularProgressIndicator(
                modifier = Modifier.fillMaxHeight().aspectRatio(1f),
                color = colors().onSecondary,
                strokeWidth = 2.dp
            )
        } else {
            text()
        }
    }
}