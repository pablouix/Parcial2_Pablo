package edu.ucne.consumiendoapi.Repositorio

import edu.ucne.consumiendoapi.remota.dto.Verbos
import edu.ucne.consumiendoapi.remota.dto.VerbosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiRepositorioVerbos @Inject constructor(
    private val api:VerbosApi
)
{
    suspend fun get() = api.get()

/*
    suspend fun get(): List<Verbos> {
        try {
            return withContext(Dispatchers.IO) {
                val resonse = api.get()
                resonse.body() ?: emptyList()
            }
        } catch (e: Exception) {
            throw e
        }
    }

 */
}