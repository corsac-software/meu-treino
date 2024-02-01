package corsac.software.meutreino.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import corsac.software.meutreino.R
import corsac.software.meutreino.etc.ext.colors

@Composable
fun CardExercicio(
    nome: String,
    series: Int,
    repeticoes: Int,
    carga: Int? = null,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
    ) {
        Column(Modifier.padding(12.dp)) {
            Text(
                text = nome,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = colors().primary,
            )

            LinhaComIcone(
                texto = stringResource(id = R.string.series_reps_resumido, series, repeticoes),
                icone = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_trophy),
                        contentDescription = stringResource(id = R.string.a11y_icone_trofeu),
                    )
                },
                textoAlternativoIcone = stringResource(id = R.string.series_reps_alt)
            )

            LinhaComIcone(
                texto = "${carga ?: 0}kg",
                icone = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_fitness_center),
                        contentDescription = stringResource(id = R.string.a11y_icone_haltere),
                    )
                },
                textoAlternativoIcone = stringResource(id = R.string.carga_alt)
            )
        }
    }
}

@Composable
fun CardNovoExercicio(onClick: () -> Unit) {
    val stroke = Stroke(
        width = 16f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(24f, 16f), 8f),
    )

    val strokeColor = MaterialTheme.colorScheme.inversePrimary

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .drawBehind {
                drawRoundRect(
                    color = strokeColor,
                    style = stroke,
                    cornerRadius = CornerRadius(16.dp.toPx())
                )
            }
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.outlinedCardColors(),
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center) {
            Row {
                LinhaComIcone(
                    cor = colors().primary,
                    texto = stringResource(id = R.string.novo_exercicio),
                    tamanho = 26,
                    fontWeight = FontWeight.Bold,
                    icone = {
                        Icon(
                            modifier = Modifier
                                .height(64.dp)
                                .size(128.dp),
                            tint = it,
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "Plus"
                        )
                    },
                    textoAlternativoIcone = "Mais",
                )
            }

        }
    }
}


@Composable
private fun LinhaComIcone(
    cor: Color = Color.Unspecified,
    texto: String,
    tamanho: Int = 14,
    fontWeight: FontWeight = FontWeight.Normal,
    icone: @Composable (cor: Color) -> Unit,
    textoAlternativoIcone: String,
) {
    Text(
        color = cor,
        text = buildAnnotatedString {
            appendInlineContent("icon", textoAlternativoIcone)
            append(texto)
        },
        inlineContent = mapOf(
            Pair("icon",
                InlineTextContent(
                    Placeholder(
                        width = 1.4.em,
                        height = (tamanho + 4).sp,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                    )
                ) {
                    icone(cor)
                }
            )),
        lineHeight = (tamanho + 2).sp,
        fontSize = tamanho.sp,
        fontWeight = fontWeight,
    )
}

@Preview
@Composable
fun CardExercicioPreview() {
    CardExercicio(
        nome = "Supino",
        series = 3,
        repeticoes = 10,
    )
}