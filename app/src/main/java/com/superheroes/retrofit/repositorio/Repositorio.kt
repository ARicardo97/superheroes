package com.superheroes.retrofit.repositorio

import com.superheroes.retrofit.servicios.ApiService
import com.superheroes.utilidades.Constantes

class Repositorio {

    private val apiService: ApiService = ApiService()

    suspend fun getCharacter() = apiService.getCharacters(
            1,Constantes.API_KEY,Constantes.HASH,100,0)

}