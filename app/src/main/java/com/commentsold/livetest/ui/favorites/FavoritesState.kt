package com.commentsold.livetest.ui.favorites

import com.commentsold.livetest.model.ProductItem
import com.commentsold.livetest.model.Variant
import com.commentsold.livetest.ui.base.State

data class FavoritesState(
    val favorites: List<ProductItem>? = null,
    val selectedFavorite: ProductItem? = null,
    val colorVariantList: List<Variant> = listOf(),
    val sizeVariantList: List<Variant> = listOf()
) : State
