package com.app.prisjakt.network.responses.hits

import com.app.prisjakt.domain.model.PriceList
import com.app.prisjakt.network.responses.model.SourceModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class HitsResults(
    @SerializedName("_index")
    var index: String? = null,
    @SerializedName("_type")
    var type: String? = null,
    @SerializedName("_id")
    var id: String? = null,
    @SerializedName("_score")
    var score: Double? = null,
    @SerializedName("price")
    var priceList: PriceList? = null,
    @SerializedName("_source")
    @Expose
    var ProdList: SourceModel? = null,
)