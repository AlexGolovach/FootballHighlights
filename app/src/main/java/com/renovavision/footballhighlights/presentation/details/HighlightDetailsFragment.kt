package com.renovavision.footballhighlights.presentation.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.renovavision.footballhighlights.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_highlight_details.*

@AndroidEntryPoint
class HighlightDetailsFragment: Fragment(R.layout.fragment_highlight_details) {

    private val args: HighlightDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView.apply {
            loadData(args.videoUrl, "text/html", "utf-8")
            settings.javaScriptEnabled = true
        }
    }
}