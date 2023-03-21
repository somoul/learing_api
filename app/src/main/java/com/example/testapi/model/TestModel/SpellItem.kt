package com.example.testapi.model.TestModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpellItem(
    @Json(name = "description")
    var description: String?,
    @Json(name = "id")
    var id: String?,
    @Json(name = "name")
    var name: String?
)