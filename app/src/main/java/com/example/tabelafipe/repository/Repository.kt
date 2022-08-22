package com.example.tabelafipe.repository

import com.example.tabelafipe.data.RetrofitInstance
import com.example.tabelafipe.model.marca.ArrayMarcas
import com.example.tabelafipe.model.modelo.ArrayModelos
import com.example.tabelafipe.model.modelo.Modelo
import retrofit2.Response

class Repository {
    suspend fun getMarcas(): Response<List<ArrayMarcas>> {
        return RetrofitInstance.api.getMarcas()
    }

    suspend fun getModelos(codigo: String): Response<List<ArrayModelos>>{
        return RetrofitInstance.api.getModelos(codigo)
    }

    suspend fun getModelo(codigo: String): Response<Modelo>{
        return RetrofitInstance.api.getModelo(codigo)
    }
}
