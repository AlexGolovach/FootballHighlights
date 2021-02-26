package com.renovavision.footballhighlights.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.renovavision.footballhighlights.AppInjector
import com.renovavision.footballhighlights.R
import com.renovavision.footballhighlights.inject.DaggerFragmentFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    internal lateinit var daggerFragmentFactory: DaggerFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        supportFragmentManager.fragmentFactory = daggerFragmentFactory
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }
}