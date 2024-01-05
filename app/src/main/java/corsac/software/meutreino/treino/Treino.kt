package corsac.software.meutreino.treino

class Treino(
    val nome: String,
    val grupoMuscular: GrupoMuscular,
    val exercicios: Set<ExercicioTreino>,
    val descricaoCustomizada: String? = null,
)