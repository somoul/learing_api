package com.example.testapi.service.placeholder

import com.example.testapi.model.placeholdermodel.PlaceholderModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT

interface PutPlaceHolderAPI {
    @PUT("posts/1")
    fun updateDataAPI(@Body data: PlaceholderModel?): Call<PlaceholderModel?>
}