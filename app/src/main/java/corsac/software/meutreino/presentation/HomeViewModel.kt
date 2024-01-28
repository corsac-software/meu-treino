package corsac.software.meutreino.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import corsac.software.meutreino.database.TreinoDao
import corsac.software.meutreino.treino.ExercicioTreino
import corsac.software.meutreino.treino.Treino

class HomeViewModel(val treinoDao: TreinoDao) : ViewModel() {
    val treinos = MutableLiveData<Map<Treino, List<ExercicioTreino>>>(emptyMap())

    suspend fun iniciarBuscaTreinos() {
        if(treinos.value.isNullOrEmpty()) {
            treinos.value = treinoDao.listarComExercicios()
        }
    }

    fun quantidadeDeExercicios(treino: Treino) = treinos.value?.get(treino)?.size ?: 0
}