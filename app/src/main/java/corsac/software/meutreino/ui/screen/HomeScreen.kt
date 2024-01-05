package corsac.software.meutreino.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import corsac.software.meutreino.treino.Exercicio
import corsac.software.meutreino.treino.ExercicioTreino
import corsac.software.meutreino.treino.GrupoMuscular
import corsac.software.meutreino.treino.Treino
import corsac.software.meutreino.ui.component.CardExercicio
import java.util.UUID

@Composable
fun HomeScreen(treinos: Set<Treino> = emptySet()) {
    BaseScreen(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, contentDescription = "Adicionar treino")
            }
        }
    ) {
        treinos.forEach { CardExercicio(it) }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(
        setOf(
            Treino(
                nome = "Treino A",
                grupoMuscular = GrupoMuscular.PEITORAL,
                exercicios = setOf(
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.SUPINO_RETO.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.SUPINO_INCLINADO.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.CRUCIFIXO.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.VOADOR.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.CROSSOVER_ROLDANA.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.TRICEPS_PULLEY.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    )
                )
            ),
            Treino(
                nome = "Treino B",
                grupoMuscular = GrupoMuscular.INFERIORES,
                exercicios = setOf(
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.AGACHAMENTO_LIVRE.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.LEG_PRESS.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.CADEIRA_EXTENSORA.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.FLEXORA_DEITADO.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    )
                )
            ),
            Treino(
                nome = "Treino C",
                grupoMuscular = GrupoMuscular.SUPERIORES,
                exercicios = setOf(
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.PUXADA_SUPINADA.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.REMADA_BAIXA.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.REMADA_CAVALO.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.VOADOR_INVERSO.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.ROSCA_DIRETA.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.ROSCA_ALTERNADA.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                    ),
                    ExercicioTreino(
                        id = UUID.randomUUID(),
                        exercicio = Exercicio.Padroes.ROSCA_MARTELO.instancia,
                        repeticoes = 10,
                        series = 4,
                        historicoCargas = emptySet()
                )
            )
            ),
        )
    )
}