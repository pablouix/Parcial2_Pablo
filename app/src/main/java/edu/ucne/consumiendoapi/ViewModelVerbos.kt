package edu.ucne.consumiendoapi

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.consumiendoapi.Repositorio.ApiRepositorioVerbos
import edu.ucne.consumiendoapi.remota.dto.VerbosApi
import javax.inject.Inject

@HiltViewModel
class ViewModelVerbos @Inject constructor(
    val repositorio: ApiRepositorioVerbos
): ViewModel()
{
    init {



    }
}
