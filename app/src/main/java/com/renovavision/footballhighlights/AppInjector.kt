package com.renovavision.footballhighlights

import android.app.Application
import com.renovavision.footballhighlights.di.MainActivityModule
import com.renovavision.footballhighlights.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        MainActivityModule::class,
        NetworkModule::class
    ]
)
@Singleton
internal interface AppInjector {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppInjector
    }

    fun inject(app: App)
}
