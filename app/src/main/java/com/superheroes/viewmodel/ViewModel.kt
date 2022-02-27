package com.superheroes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.superheroes.retrofit.repositorio.Repositorio

class ViewModel(application: Application): AndroidViewModel(application)  {

    private val repositorio: Repositorio = Repositorio()

    suspend fun getCharacters() = repositorio.getCharacter()

}