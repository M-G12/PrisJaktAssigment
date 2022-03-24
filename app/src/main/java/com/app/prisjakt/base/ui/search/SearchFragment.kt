package com.app.prisjakt.base.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.app.prisjakt.util.ConnectionStatus
import com.example.myapplication.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {
    @Inject
    lateinit var connectionStatus: ConnectionStatus
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    elevation = 15.dp
                ) {
                    Scaffold(topBar = {
                        SearchViewText(
                            isNetworkAvailable = connectionStatus
                                .observeAsState(false).value,
                            viewModel = viewModel
                        )
                    }) {
                        val productInfo = viewModel.products.value
                        Box {
                            LazyColumn {
                                itemsIndexed(productInfo) { _, product ->
                                    ProductListViewCard(productInfo = product, onClick = {
                                        val bundle = Bundle()
                                        bundle.putParcelable("product", product)
                                        findNavController().navigate(
                                            R.id.action_searchFragment_to_productFragment,
                                            bundle
                                        )
                                    })
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

