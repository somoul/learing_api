package com.example.testapi.service.placeholder
import com.example.testapi.model.placeholdermodel.PlaceholderModel
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PlaceholderAPIInterface {
    @GET("posts")
    fun getDataPlaceholderAPI():Call<List<PlaceholderModel>>?

    @POST("posts")
    fun poshDataPlaceholderAPI(@Body dataModel: PlaceholderModel?):Call<PlaceholderModel>?
    //postData(@Body dataModel: DataModel?): Call<DataModel?>?

}
