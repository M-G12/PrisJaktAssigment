package com.app.prisjakt.network.mapper

import com.app.prisjakt.domain.model.ProductInfo
import com.app.prisjakt.util.DomainMapper
import com.app.prisjakt.network.responses.hits.HitsResults

class ProductDtoMapper : DomainMapper<HitsResults, ProductInfo> {
    override fun mapToDomainModel(model: HitsResults): ProductInfo {
        return ProductInfo(
            id = model.ProdList?.ProdList?.id,
            name = model.ProdList?.ProdList?.name,
            dateOfCreation = model.ProdList?.ProdList?.dateOfCreation,
            priceList = model.ProdList?.priceList,
            mediaList = model.ProdList?.ProdList?.mediaList?.productImages?.images
        )
    }

    fun toDomainList(initial: List<HitsResults>): List<ProductInfo> {
        return initial.map {
            mapToDomainModel(it)
        }
    }
}