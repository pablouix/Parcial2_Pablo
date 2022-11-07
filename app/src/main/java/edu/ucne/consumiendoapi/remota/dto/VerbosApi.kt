package edu.ucne.consumiendoapi.remota.dto

import retrofit2.Response
import retrofit2.http.GET

interface VerbosApi {
    @GET("verbos")
    suspend fun get(): List<Verbos>
}