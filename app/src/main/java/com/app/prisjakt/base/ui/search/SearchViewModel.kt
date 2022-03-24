package com.app.prisjakt.base.ui.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.prisjakt.domain.model.ProductInfo
import com.app.prisjakt.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject
constructor(
    private val repository: ProductRepository
) : ViewModel() {
    val products: MutableState<List<ProductInfo>> = mutableStateOf(ArrayList())

    fun search(text: String) {
        viewModelScope.launch {
            products.value = repository.search(text)
        }
    }
}