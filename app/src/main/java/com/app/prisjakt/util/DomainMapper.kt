package com.app.prisjakt.util

interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel
}