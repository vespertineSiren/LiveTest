package com.commentsold.livetest.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.google.android.material.progressindicator.CircularProgressIndicator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Base for all fragments in the project
 * This will:
 *  - clean/create viewbindings
 *  - observe state flows
 *  - init views
 *  - display error dialogs, toasts,
 */
abstract class BaseFragment<VB : ViewBinding, STATE : State, VM : BaseViewModel<STATE>> :
    Fragment() {

    private var _binding: VB by autoCleaned()
    val binding: VB get() = _binding

    protected abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeState()
    }

    abstract fun initView()
    abstract fun render(state: STATE)

    private fun observeState() {
        viewModel.state
            .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> render(state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    fun showProgressBar(show: Boolean, progressBar: CircularProgressIndicator) {
        progressBar.isVisible = show
    }

    fun createToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    companion object {
        private const val ERROR_DIALOG_TAG = "error_dialog"
    }
}
