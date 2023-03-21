package com.example.testapi.service

import com.example.testapi.model.TestModel.SpellItem
import retrofit2.Call
import retrofit2.http.GET

interface TestCharacterAPI {
    @GET("spells")
    fun getCharacterTest(): Call<List<SpellItem>>
}