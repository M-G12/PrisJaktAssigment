package com.app.prisjakt.di

import com.app.prisjakt.network.responses.service.ProductSearchService
import com.app.prisjakt.network.mapper.ProductDtoMapper
import com.app.prisjakt.repository.ProductRepository
import com.app.prisjakt.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideProductRepository(
        productSearchService: ProductSearchService,
        productDtoMapper: ProductDtoMapper
    ): ProductRepository {
        return ProductRepositoryImpl(
            productSearchService = productSearchService,
            mapper = productDtoMapper
        )
    }
}