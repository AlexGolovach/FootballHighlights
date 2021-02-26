package com.renovavision.footballhighlights.presentation.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.renovavision.footballhighlights.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_highlight_details.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HighlightDetailsFragment: Fragment(R.layout.fragment_highlight_details) {

    private val viewModel: HighlightDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.data.collect {
                webView.apply {
                    loadData(it, "text/html", "utf-8")
                    settings.javaScriptEnabled = true
                }
            }
        }
    }
}