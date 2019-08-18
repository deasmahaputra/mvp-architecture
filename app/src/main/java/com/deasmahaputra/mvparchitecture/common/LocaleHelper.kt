package com.deasmahaputra.mvparchitecture.common

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import java.util.*


class LocaleHelper(private val context: Context?) {

    fun onAttach(): Context? = setLocale(context, "id")

    private fun setLocale(context: Context?, language: String): Context? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, language)
        } else updateResourcesLegacy(context, language)
    }

    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(context: Context?, language: String): Context? {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val configuration = context?.resources?.configuration
        configuration?.setLocale(locale)
        configuration?.setLayoutDirection(locale)

        return configuration?.let { context?.createConfigurationContext(it) }
    }

    @Suppress("DEPRECATION")
    private fun updateResourcesLegacy(context: Context?, language: String): Context? {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val resources = context?.resources
        val configuration = context?.resources?.configuration
        configuration?.locale = locale
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration?.setLayoutDirection(locale)
        }
        resources?.updateConfiguration(configuration, resources.displayMetrics)

        return context
    }
}