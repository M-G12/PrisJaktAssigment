package com.app.prisjakt.network.responses.hits

import com.google.gson.annotations.SerializedName

data class HitsDataStructure(
    @SerializedName("total")
    var total: Int? = null,
    @SerializedName("max_score")
    var maxScor: Double? = null,
    @SerializedName("hits")
    var listOfHits: List<HitsResults>? = null
)