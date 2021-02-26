package com.renovavision.footballhighlights.di

import androidx.lifecycle.ViewModelProvider
import com.renovavision.footballhighlights.inject.ViewModelFactory
import com.renovavision.footballhighlights.presentation.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @Binds
    fun viewModelProviderFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(
        modules = [
            HighlightsModule::class,
            NavHostFragmentModule::class
        ]
    )
    fun mainActivity(): MainActivity
}
