package com.commentsold.livetest.ui.home

import com.commentsold.livetest.model.ProductItem
import com.commentsold.livetest.ui.base.State

data class HomeState(
    val productList: List<ProductItem>? = null
) : State