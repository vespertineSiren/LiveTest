package com.commentsold.livetest.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import com.commentsold.livetest.databinding.FragmentFavoritesBinding
import com.commentsold.livetest.model.ProductItem
import com.commentsold.livetest.ui.base.BaseFragment
import com.commentsold.livetest.ui.base.autoCleaned
import com.commentsold.livetest.utils.extensions.hiltLiveTestNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment :
    BaseFragment<FragmentFavoritesBinding, FavoritesState, FavoritesViewModel>() {

    override val viewModel: FavoritesViewModel by hiltLiveTestNavGraphViewModels()

    private val favoriteProductAdapter by autoCleaned(
        initializer = { FavoritesAdapter(::onItemClicked) }
    )

    private val colorVariantAdapter by autoCleaned(
        initializer = { VariantAdapter() }
    )

    private val sizeVariantAdapter by autoCleaned(
        initializer = { VariantAdapter() }
    )

    override fun initView() {
        with(binding) {
            favoritesProductRecyclerView.adapter = favoriteProductAdapter
            favoritesColorRecyclerView.adapter = colorVariantAdapter
            favoritesSizeRecyclerView.adapter = sizeVariantAdapter
        }

        viewModel.getFavoritesList()
    }

    override fun render(state: FavoritesState) {
        val favoritesList = state.favorites
        val colorVariantsList = state.colorVariantList
        val sizeVariantsList = state.sizeVariantList

        if (favoritesList != null) favoriteProductAdapter.submitList(favoritesList)
        colorVariantAdapter.submitList(colorVariantsList)
        sizeVariantAdapter.submitList(sizeVariantsList)
    }

    private fun onItemClicked(selected: ProductItem) {
        viewModel.setSelectProductItem(selected)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentFavoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)
}