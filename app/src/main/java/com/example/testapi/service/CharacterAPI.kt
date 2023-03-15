package com.example.testapi.service

import com.example.testapi.model.CharacterResponse
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET


interface CharacterAPI {
    @GET("characters")
    fun getCharacters(): Call<List<CharacterResponse>>?
}
