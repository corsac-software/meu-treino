package corsac.software.meutreino.treino

import corsac.software.meutreino.R

enum class GrupoMuscular(
    val resourceNomeExibicao: Int?
) {
    SUPERIORES(R.string.grupo_muscular_superiores),
    INFERIORES(R.string.grupo_muscular_inferiores),
    PEITORAL(R.string.grupo_muscular_peitoral),
    CUSTOMIZADO(null)
}