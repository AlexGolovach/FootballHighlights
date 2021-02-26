package com.renovavision.footballhighlights.presentation.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.renovavision.footballhighlights.R
import kotlinx.android.synthetic.main.fragment_highlight_details.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class HighlightDetailsFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_highlight_details) {

    private val viewModel: HighlightDetailsViewModel by viewModels { viewModelFactory }

    private val args: HighlightDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView.apply {
            loadData(args.videoUrl, "text/html", "utf-8")
            settings.javaScriptEnabled = true
        }

//        lifecycleScope.launchWhenStarted {
//            viewModel.data.collect {
//                webView.apply {
//                    loadData(it, "text/html", "utf-8")
//                    settings.javaScriptEnabled = true
//                }
//            }
//        }
    }
}