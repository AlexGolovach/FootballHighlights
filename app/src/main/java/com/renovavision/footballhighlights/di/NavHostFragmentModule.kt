package com.renovavision.footballhighlights.di

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.renovavision.footballhighlights.inject.FragmentKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
object NavHostFragmentModule {

    @Provides
    @IntoMap
    @FragmentKey(NavHostFragment::class)
    fun navHostFragment(): Fragment = NavHostFragment()
}