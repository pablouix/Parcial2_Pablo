package edu.ucne.consumiendoapi.remota.dto

import retrofit2.http.GET

interface VerbosApi {
    @GET("private-a127e-verbos.apiary-mock.com/verbos")
    suspend fun get(): List<Verbos>
}