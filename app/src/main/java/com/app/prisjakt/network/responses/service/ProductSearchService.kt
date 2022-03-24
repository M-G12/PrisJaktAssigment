package com.app.prisjakt.network.responses.service

import com.app.prisjakt.network.responses.model.ProductSearchResponse

import retrofit2.http.POST
import retrofit2.http.Query

interface ProductSearchService {
    @POST("_search")
    suspend fun search(
        @Query("q")
        productName: String?
    ): ProductSearchResponse
}