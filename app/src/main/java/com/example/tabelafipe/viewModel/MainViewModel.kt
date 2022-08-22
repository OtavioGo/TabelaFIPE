package com.example.tabelafipe.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tabelafipe.model.marca.ArrayMarcas
import com.example.tabelafipe.model.modelo.ArrayModelos
import com.example.tabelafipe.model.modelo.Modelo
import com.example.tabelafipe.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<List<ArrayMarcas>>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<List<ArrayModelos>>> = MutableLiveData()
    val myResponse3: MutableLiveData<Response<Modelo>> = MutableLiveData()

    fun getMarcas() {
        viewModelScope.launch {
            val response = repository.getMarcas()
            myResponse.value = response
        }
    }

    fun getModelos(codigo: String){
        viewModelScope.launch {
            val response = repository.getModelos(codigo)
            myResponse2.value = response
        }
    }

    fun getModelo(codigo: String){
        viewModelScope.launch {
            val response = repository.getModelo(codigo)
            myResponse3.value = response
        }
    }
}
