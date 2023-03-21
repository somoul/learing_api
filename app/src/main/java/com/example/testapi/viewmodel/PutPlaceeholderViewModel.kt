package com.example.testapi.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testapi.model.placeholdermodel.PlaceholderModel
import com.example.testapi.service.placeholder.PutPlaceHolderAPI
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class PutPlaceHolderViewModel : ViewModel() {

    fun putPlaceHolderViewModel() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitApi = retrofit.create(PutPlaceHolderAPI::class.java)
        val dataModel = PlaceholderModel(body = "KSO", title = "KSOTitle", userId = 111, id = 0,)
        val call : Call<PlaceholderModel?> = retrofitApi.updateDataAPI(dataModel)
        call.enqueue(object : Callback<PlaceholderModel?>{
            override fun onResponse(
                call: Call<PlaceholderModel?>,
                response: Response<PlaceholderModel?>
            ) {
                val modelBody :PlaceholderModel ?=response.body()
                val resp =
                    "Response Code : " + response.code() + "\n" + "User ID : " + modelBody!!.userId + "\n" + "ID : " +modelBody!!.id + "\n" + "Title : " +modelBody!!.title+ "Body : " +modelBody!!.body
             println("=============== $resp")
            }
            override fun onFailure(call: Call<PlaceholderModel?>, t: Throwable) {
                println(t)
            }

        })

    }


}