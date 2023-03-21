package com.example.testapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapi.model.TestModel.SpellItem
import com.example.testapi.service.CharacterAPI
import com.example.testapi.service.TestCharacterAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class TestMainViewModel : ViewModel() {

    fun getDataAPi() {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofit = Retrofit.Builder().baseUrl("https://hp-api.onrender.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build()
            val service = retrofit.create(TestCharacterAPI::class.java)
            val call = service.getCharacterTest()
            call?.enqueue(object : Callback<List<SpellItem>> {
                override fun onResponse(
                    call: Call<List<SpellItem>>,
                    response: Response<List<SpellItem>>
                ) {
                    if (response.isSuccessful) {
                        val body = response.body() ?: emptyList()
                        println(" response body : $body")
                    }
                }

                override fun onFailure(call: Call<List<SpellItem>>, t: Throwable) {
                    println("onFailure")
                }

            })

        }
    }

}