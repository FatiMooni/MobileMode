package com.project.tdm2.customs

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.tdm2.R
import com.project.tdm2.helpers.PreferenceProvider


open class CustomActivity : AppCompatActivity() {

    private lateinit var currentTheme: String
    private lateinit var sharedPref: PreferenceProvider

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = PreferenceProvider(context = this)
        currentTheme = sharedPref.load()

        setAppTheme(currentTheme)
    }

    override fun onResume() {
        super.onResume()
        val theme = sharedPref.load()
        if(currentTheme != theme)
            recreate()
    }

    private fun setAppTheme(currentTheme: String) {
        when (currentTheme) {
            "Red" -> setTheme(R.style.AppTheme)
            "Blue" -> setTheme(R.style.BlueAppTheme)
        }
    }
}