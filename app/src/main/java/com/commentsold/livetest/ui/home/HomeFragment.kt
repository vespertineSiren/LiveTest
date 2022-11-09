package com.commentsold.livetest.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.commentsold.livetest.databinding.FragmentHomeBinding
import com.commentsold.livetest.ui.base.BaseFragment
import com.commentsold.livetest.ui.base.autoCleaned
import com.commentsold.livetest.utils.extensions.hiltLiveTestNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeState, HomeViewModel>() {

    override val viewModel: HomeViewModel by hiltLiveTestNavGraphViewModels()

    private val liveProductAdapter by autoCleaned(
        initializer = { HomeAdapter() }
    )

    override fun initView() {
        with(binding) {

        }
        viewModel.getProductList()
    }


    override fun render(state: HomeState) {
        //TODO:
        val foundList = state.productList
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
}