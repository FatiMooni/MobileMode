package com.project.tdm2.helpers

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager






class PreferenceProvider(context: Context) {
    private val PREFERENCE_NAME = "SharedPreferenceExample"



    internal var mySharedPref: SharedPreferences = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
    lateinit var editor: SharedPreferences.Editor


    //Create keys to manage the shared preferences
    companion object {
        const val DEVELOP_MODE = false
        private const val DEVICE_TOKEN = "data.source.prefs.DEVICE_TOKEN"
    }

    /**
     * For teh dark mode preferences
     */
    //Save the Dark mode
    @SuppressLint("CommitPrefEdits")
    fun setSecondModeState(state: String) {
        editor = mySharedPref.edit()
        editor.putString("current_theme", state)
        editor.commit()

    }

    //Get the dark Mode State
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    fun load(): String {
        return mySharedPref.getString("current_theme", "Red_theme")
    }

    //create a variable to access to the shared preferences
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)


    //enable write/read from my preference provider
    var deviceToken = preferences.getString(DEVICE_TOKEN, "")
        set(value) = preferences.edit().putString(DEVICE_TOKEN, value).apply()

    //About Language
    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)


}





