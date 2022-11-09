package com.commentsold.livetest.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.commentsold.livetest.databinding.FragmentLoginBinding
import com.commentsold.livetest.ui.base.BaseFragment
import com.commentsold.livetest.utils.extensions.hiltLiveTestNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginState, LoginViewModel>() {

    override val viewModel: LoginViewModel by hiltLiveTestNavGraphViewModels()

    override fun initView() {
        with(binding) {
            guestButton.setOnClickListener {
                viewModel.handleGuestButtonTap()
            }

            userButton.setOnClickListener {
                viewModel.handleUserButtonTap()
            }
        }
    }

    override fun render(state: LoginState) {
        if(state.isLoggedIn) {
            findNavController().navigate(
                LoginFragmentDirections.loginToHome()
            )
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
}