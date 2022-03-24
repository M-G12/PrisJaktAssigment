package com.app.prisjakt.network.responses.model

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("id")
    var id: Long? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("created_at")
    var dateOfCreation: String? = null,
    @SerializedName("media")
    var mediaList: MediaList? = null
)