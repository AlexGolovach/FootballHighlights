package com.renovavision.footballhighlights.presentation.splash

import android.animation.Animator
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.renovavision.footballhighlights.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_splash.*

@AndroidEntryPoint
class SplashFragment: Fragment(R.layout.fragment_splash) {

    private val animatorListener = object : Animator.AnimatorListener {

        override fun onAnimationEnd(p0: Animator?) {
            findNavController().navigate(R.id.navigate_to_highlights)
        }

        override fun onAnimationRepeat(p0: Animator?) {}

        override fun onAnimationCancel(p0: Animator?) {}

        override fun onAnimationStart(p0: Animator?) {}

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animation_view.addAnimatorListener(animatorListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        animation_view.removeAnimatorListener(animatorListener)
    }
}