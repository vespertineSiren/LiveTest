package com.commentsold.livetest.ui.favorites

import androidx.lifecycle.viewModelScope
import com.commentsold.livetest.data.remote.LiveTestService
import com.commentsold.livetest.model.ProductItem
import com.commentsold.livetest.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val service: LiveTestService
) : BaseViewModel<FavoritesState>(initialState = FavoritesState()) {

    fun getFavoritesList() {
        viewModelScope.launch {
            service.getLargeCollection().body()?.let { favoritesList ->
                setState { state ->
                    state.copy(
                        favorites = favoritesList
                    )
                }
            }
        }
    }

    fun setSelectProductItem(selected: ProductItem) {
        val colorVariants = selected.getColorVariants()
        val sizeVariants = selected.getSizeVariants()

        setState { state ->
            state.copy(
                selectedFavorite = selected,
                colorVariantList = colorVariants,
                sizeVariantList = sizeVariants
            )
        }
    }
}