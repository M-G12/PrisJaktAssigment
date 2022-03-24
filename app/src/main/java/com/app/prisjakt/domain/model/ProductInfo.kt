package com.app.prisjakt.domain.model

import android.os.Parcelable
import com.app.prisjakt.network.responses.model.Images
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize

data class ProductInfo(
    val id: Long? = null,
    val name: String? = null,
    val dateOfCreation: String? = null,
    var priceList: @RawValue PriceList? = null,
    val mediaList: @RawValue Images? = null
) : Parcelable