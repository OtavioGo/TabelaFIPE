package com.example.tabelafipe.data

import com.example.tabelafipe.model.marca.ArrayMarcas
import com.example.tabelafipe.model.modelo.ArrayModelos
import com.example.tabelafipe.model.modelo.Modelo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FipeAPI {

    @GET("fipe/api/v1/carros/marcas")
    suspend fun getMarcas(): Response<List<ArrayMarcas>>

    @GET("fipe/api/v1/carros/marcas/{codigo}/modelos")
    suspend fun getModelos(
        @Path("codigo") codigo: String
    ): Response<List<ArrayModelos>>

    @GET("fipe/api/v1/carros/marcas/{codigo}/modelos")
    suspend fun getModelo(
        @Path("codigo") codigo: String
    ): Response<Modelo>
}