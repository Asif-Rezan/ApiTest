package com.asifrezan.apitest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.asifrezan.apitest.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(val productRepository: ProductRepository) : ViewModel() {

    val list = productRepository.getProduct().cachedIn(viewModelScope)

}