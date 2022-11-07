package edu.ucne.consumiendoapi

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.consumiendoapi.Repositorio.ApiRepositorioVerbos
import edu.ucne.consumiendoapi.remota.dto.Verbos
import edu.ucne.consumiendoapi.remota.dto.VerbosApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


data class VerbosListUiState(
    val verbos: List<Verbos> = emptyList()
)


@HiltViewModel
class ViewModelVerbos @Inject constructor(
    val repositorio: ApiRepositorioVerbos
): ViewModel()
{

    var _uiState = MutableStateFlow(VerbosListUiState())


     //val _uiState = MutableStateFlow(VerbosListUiState())
   // val uiState: StateFlow<VerbosListUiState> = _uiState.asStateFlow()

    //private val _uiState = MutableStateFlow(VerbosListUiState())
    //val uiState: StateFlow<VerbosListUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            _uiState.update {
                try {
                    it.copy(verbos = repositorio.get())
                }catch (ioe: Exception){
                    it.copy(error("error"))
                }

            }
        }
    }



    /*

    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(verbos = repositorio.get().sortedBy { it.Verbo })
            }
        }
    }




init {
    viewModelScope.launch {
        var list = repositorio.get()
        _uiState.update {
            it.copy(
                verbos = list.map {
                        verbosResponse ->
                    //estamos creando una lista
                    Verbos(
                        Verbo = verbosResponse.Verbo,
                        Categoria = verbosResponse.Categoria,
                        Nivel = verbosResponse.Nivel,
                        Imagen = verbosResponse.Imagen,
                    )
                })
        }
    }


}
*/

}
