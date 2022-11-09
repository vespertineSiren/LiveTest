package com.commentsold.livetest.ui.home

import androidx.lifecycle.viewModelScope
import com.commentsold.livetest.data.remote.LiveTestService
import com.commentsold.livetest.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val service: LiveTestService
) : BaseViewModel<HomeState>(initialState = HomeState()) {

    fun getProductList() {
        viewModelScope.launch {
            val list = service.getCollection()
            list.body()?.let { itemList ->
                setState { state ->
                    state.copy(
                        productList = itemList
                    )
                }
            }
        }
    }
}