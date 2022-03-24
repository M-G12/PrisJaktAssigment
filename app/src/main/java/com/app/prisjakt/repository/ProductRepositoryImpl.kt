package com.app.prisjakt.repository

import com.app.prisjakt.domain.model.ProductInfo
import com.app.prisjakt.network.responses.service.ProductSearchService
import com.app.prisjakt.network.mapper.ProductDtoMapper
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productSearchService: ProductSearchService,
    private val mapper: ProductDtoMapper
) : ProductRepository {

    override suspend fun search(productName: String?): List<ProductInfo> {
        return mapper.toDomainList(
            productSearchService.search(productName)
                .hitsDataStructure?.listOfHits!!
        )
    }
}