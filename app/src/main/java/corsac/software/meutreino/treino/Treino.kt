package corsac.software.meutreino.treino

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Treino(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nome: String,
    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    val grupoMuscular: GrupoMuscular,
    val descricaoCustomizada: String? = null,
)