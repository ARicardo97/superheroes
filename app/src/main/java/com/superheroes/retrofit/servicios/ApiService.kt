package com.superheroes.retrofit.servicios

import com.superheroes.model.response.ResponseCharacter
import com.superheroes.utilidades.Constantes
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts:Int?,
        @Query("apikey") apikey:String?,
        @Query("hash") hash:String?,
        @Query("limit") limit:Int?,
        @Query("offset") offset:Int?
    ):Response<ResponseCharacter>

    companion object{
        operator fun invoke():ApiService{
            val client = OkHttpClient()
                .newBuilder().readTimeout(40, TimeUnit.SECONDS)
                .connectTimeout(40, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(Constantes.URL_GLOBAL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(ApiService::class.java)
        }

    }
}