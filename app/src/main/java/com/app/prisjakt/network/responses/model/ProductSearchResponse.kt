package com.app.prisjakt.network.responses.model

import com.app.prisjakt.network.responses.hits.HitsDataStructure
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductSearchResponse(
    @SerializedName("hits")
    @Expose
    val hitsDataStructure: HitsDataStructure? = null
)