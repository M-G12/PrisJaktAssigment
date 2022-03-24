package com.app.prisjakt.network.responses.model

import com.app.prisjakt.domain.model.PriceList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SourceModel(
    @SerializedName("price")
    var priceList: PriceList? = null,

    @SerializedName("product")
    @Expose
    var ProdList: ProductDto? = null,

    )
