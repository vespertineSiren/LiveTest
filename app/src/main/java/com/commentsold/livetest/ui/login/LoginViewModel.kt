package com.commentsold.livetest.ui.login


import androidx.lifecycle.viewModelScope
import com.commentsold.livetest.data.remote.LiveTestService
import com.commentsold.livetest.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val service: LiveTestService
) : BaseViewModel<LoginState>(initialState = LoginState()) {

    fun handleGuestButtonTap() {
        viewModelScope.launch {
            val thing = service.getGuestToken()
            setState { state ->
                state.copy(
                    isLoggedIn = thing.isSuccessful
                )
            }
        }
    }

    fun handleUserButtonTap() {
        viewModelScope.launch {
            val thing = service.getGuestToken()
            setState { state ->
                state.copy(
                    isLoggedIn = thing.isSuccessful
                )
            }
        }
    }
}