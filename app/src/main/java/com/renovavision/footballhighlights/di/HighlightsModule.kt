package com.renovavision.footballhighlights.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.renovavision.footballhighlights.inject.FragmentKey
import com.renovavision.footballhighlights.inject.ViewModelKey
import com.renovavision.footballhighlights.presentation.details.HighlightDetailsFragment
import com.renovavision.footballhighlights.presentation.list.HighlightsListFragment
import com.renovavision.footballhighlights.presentation.list.HighlightsListViewModel
import com.renovavision.footballhighlights.presentation.splash.SplashFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HighlightsModule {

    @Binds
    @IntoMap
    @FragmentKey(SplashFragment::class)
    fun splashFragment(fragment: SplashFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(HighlightsListFragment::class)
    fun highlightsListFragment(fragment: HighlightsListFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(HighlightDetailsFragment::class)
    fun highlightDetailsFragment(fragment: HighlightDetailsFragment): Fragment

    @Binds
    @IntoMap
    @ViewModelKey(HighlightsListViewModel::class)
    fun highlightsListViewModel(viewModel: HighlightsListViewModel): ViewModel
}