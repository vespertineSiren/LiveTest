package com.commentsold.livetest.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.updateAndGet

/**
 * Base for all the ViewModels
 *
 * Variables:
 *  _state:         the mutable State of this ViewModel
 *  state:          state to be exposed to the UI layer
 *  currentState:   current UI state
 *
 */
abstract class BaseViewModel<STATE : State>(initialState: STATE) : ViewModel() {

    private val _state = MutableStateFlow(initialState)

    val state: StateFlow<STATE> = _state.asStateFlow()

    val currentState: STATE get() = state.value

    /**
     * Updates the state of this ViewModel and returns the new state
     *
     * @param update Lambda callback with old state to calculate a new state
     * @return The updated state
     */
    protected fun setState(update: (old: STATE) -> STATE): STATE = _state.updateAndGet(update)
}
