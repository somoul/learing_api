package com.example.testapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapi.model.CharacterResponse
import com.example.testapi.service.CharacterAPI
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainViewModel : ViewModel() {

    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://hp-api.onrender.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(CharacterAPI::class.java)
            val call = service.getCharacters()
            call?.enqueue(object : Callback<List<CharacterResponse>> {
                override fun onResponse(
                    call: Call<List<CharacterResponse>>,
                    response: Response<List<CharacterResponse>>
                ) {
                    if (response.isSuccessful) {
                        val body = response.body() ?: emptyList()
                        println("onResponse")
                        println(body.first())
                    }

                }

                override fun onFailure(call: Call<List<CharacterResponse>>, t: Throwable) {
                    println("onFailure  $t")
                }
            })

//            call.enqueue(object : Callback<MyResponseObject> {
//                override fun onFailure(call: Call<MyResponseObject>?, t: Throwable?) { }
//
//                override fun onResponse(call: Call<MyResponseObject>?, response: Response<List<Class>>?) {
//                    if (response != null && response.isSuccessful) {
//                        val myListData: MyResponseObject = response.body()
//                        setUpRecyclerView(myListData) // The usual way of setting up a RecyclerView
//                    }
//                }
//            })
        }

    }


}

class data {
    var name: String? = null
    var sdfsd: String? = null
    var fsdfs: String? = null
    var namsdfsdfe: String? = null
    var dfsdfsd: String? = null
}