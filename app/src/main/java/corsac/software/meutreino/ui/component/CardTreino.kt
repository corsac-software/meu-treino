package corsac.software.meutreino.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import corsac.software.meutreino.R
import corsac.software.meutreino.etc.ext.colors
import corsac.software.meutreino.treino.GrupoMuscular
import corsac.software.meutreino.treino.Treino

@Composable
fun CardTreino(
    nome: String,
    grupoMuscular: GrupoMuscular,
    quantidadeExercicios: Int,
    descricaoCustomizada: String? = null,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
    ) {
        Column(Modifier.padding(12.dp)) {
            Text(
                text = nome,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = colors().primary,
            )

            val textoDescricao = if(grupoMuscular == GrupoMuscular.CUSTOMIZADO)
                descricaoCustomizada!!
            else
                stringResource(grupoMuscular.resourceNomeExibicao!!)

            Row {
                Text(text = textoDescricao, fontSize = 16.sp, color = colors().secondary)
                Text(text = " • ", fontSize = 16.sp, color = colors().secondary)
                Text(text = stringResource(R.string.contagem_exercicios, quantidadeExercicios),
                    fontSize = 16.sp,
                    color = colors().secondary
                )
            }
        }
    }
}

@Composable
fun CardTreino(
    treino: Treino,
    quantidadeExercicios: Int
) {
    CardTreino(
        nome = treino.nome,
        grupoMuscular = treino.grupoMuscular,
        quantidadeExercicios = quantidadeExercicios,
        descricaoCustomizada = treino.descricaoCustomizada
    )
}