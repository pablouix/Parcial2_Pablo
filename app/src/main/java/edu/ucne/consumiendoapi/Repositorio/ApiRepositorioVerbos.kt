package edu.ucne.consumiendoapi.Repositorio

import edu.ucne.consumiendoapi.remota.dto.VerbosApi
import javax.inject.Inject

class ApiRepositorioVerbos @Inject constructor(
    private val api:VerbosApi
)
{
    suspend fun get() = api.get()
}