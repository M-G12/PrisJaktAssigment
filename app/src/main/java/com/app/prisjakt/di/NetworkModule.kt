package com.app.prisjakt.di

import android.content.Context
import com.app.prisjakt.network.responses.service.ProductSearchService
import com.app.prisjakt.network.mapper.ProductDtoMapper
import com.app.prisjakt.util.ConnectionStatus
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideProductMapper(): ProductDtoMapper {
        return ProductDtoMapper()
    }

    @Singleton
    @Provides
    fun provideProductSearchService(): ProductSearchService {
        return Retrofit.Builder()
            .baseUrl("https://search-pj-campaigns-index-oyaq7ruf3du2owxiiiuhyqcgcm.eu-west-1.es.amazonaws.com/campaign-se-4-deals/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ProductSearchService::class.java)
    }

    @Singleton
    @Provides
    fun provideNetWorkAvailability(@ApplicationContext context: Context): ConnectionStatus {
        return ConnectionStatus(context = context)
    }
}