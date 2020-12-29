package com.renovavision.footballhighlights.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.renovavision.footballhighlights.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_highlights_list.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HighlightsListFragment : Fragment(R.layout.fragment_highlights_list) {

    private val viewModel: HighlightsListViewModel by viewModels()

    private val adapter = HighlightAdapter {
        findNavController().navigate(
            HighlightsListFragmentDirections.navigateToHighlightDetails(it)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = adapter

        retry_button.setOnClickListener {
            viewModel.loadHighlights()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.observeState.collect {
                adapter.submitList(it.data)

                recycler_view.visibility = if (!it.showError) View.VISIBLE else View.GONE
                error_container.visibility = if (it.showError) View.VISIBLE else View.GONE
                progress.visibility = if (it.isLoading) View.VISIBLE else View.GONE
            }
        }
    }
}