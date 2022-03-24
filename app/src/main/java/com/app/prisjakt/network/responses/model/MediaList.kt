package com.app.prisjakt.network.responses.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MediaList(
    @SerializedName("product_images")
    @Expose
    var productImages: ProductImages? = null,
)

data class ProductImages(
    @SerializedName("first")
    @Expose
    var images: Images? = null,
)

data class Images(
    @SerializedName("180")
    @Expose
    var image180x180: String? = null,
    @SerializedName("280")
    @Expose
    var image280x280: String? = null,
    @SerializedName("800")
    @Expose
    var image800x800: String? = null
)