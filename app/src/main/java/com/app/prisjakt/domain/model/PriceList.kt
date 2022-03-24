package com.app.prisjakt.domain.model

import com.google.gson.annotations.SerializedName


data class PriceList(
    @SerializedName("offer")
    var offer: Int? = null,
    @SerializedName("diff_percentage")
    var diffPercentage: Double? = null,
    @SerializedName("offer_previous_price")
    var offerPreviousPrice: Double? = null,
    @SerializedName("offer_incl_shipping")
    var offerInclShipping: Double? = null,
    @SerializedName("compare")
    var compare: Double? = null,
)
