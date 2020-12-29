package com.renovavision.footballhighlights.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.renovavision.footballhighlights.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }
}