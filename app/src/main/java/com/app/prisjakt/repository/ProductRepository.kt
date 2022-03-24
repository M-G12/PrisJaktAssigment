package com.app.prisjakt.repository

import com.app.prisjakt.domain.model.ProductInfo
import kotlinx.parcelize.RawValue
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductRepository {
    @POST("_search")
    suspend fun search(
        @Query("q")
        productName: String?
    ): @RawValue List<ProductInfo>
}