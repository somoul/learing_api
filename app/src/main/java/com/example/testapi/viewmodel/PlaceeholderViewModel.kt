package com.example.testapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapi.model.placeholdermodel.PlaceholderModel
import com.example.testapi.service.placeholder.PlaceholderAPIInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class PlaceHolderViewModel : ViewModel() {
    fun getPlaceHolder() {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
            val service = retrofit.create(PlaceholderAPIInterface::class.java)
            val call = service.getDataPlaceholderAPI()
            call?.enqueue(object : Callback<List<PlaceholderModel>> {
                override fun onResponse(
                    call: Call<List<PlaceholderModel>>,
                    response: Response<List<PlaceholderModel>>
                ) {
                    if (response.isSuccessful) {
                        val body = response.body() ?: emptyList()
                        println("Show PlaceHolderAPI onResponse 22222 : ${body[0].userId}")
                    }
                }

                override fun onFailure(call: Call<List<PlaceholderModel>>, t: Throwable) {
                    println("onFailure: $t")
                }


            })


        }


    }

    fun pushPlaceHolder() {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
            val service = retrofit.create(PlaceholderAPIInterface::class.java)
            val dataModel =
                PlaceholderModel(body = "SomOul", id = 0, title = "Moneka11", userId = 0)
            val call = service.poshDataPlaceholderAPI(dataModel)
            call!!.enqueue(object : Callback<PlaceholderModel?> {
                override fun onResponse(
                    call: Call<PlaceholderModel?>,
                    response: Response<PlaceholderModel?>
                ) {
                    val model: PlaceholderModel? = response.body()
                    val resp = "Response code 00: " + response.code() + "\n" + " User userId : " + model!!.userId + "\n" + " id : " + model!!.id + " title : " + model!!.title + "  body : " + model!!.body
                    println("1111=1=1==1=1 :$resp")
                }

                override fun onFailure(call: Call<PlaceholderModel?>, t: Throwable) {
                    println("$t")
                }
            })


        }
    }


}