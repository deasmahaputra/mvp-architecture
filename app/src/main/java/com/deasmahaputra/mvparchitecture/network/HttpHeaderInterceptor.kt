package com.deasmahaputra.mvparchitecture.base.extension.network

import com.deasmahaputra.mvparchitecture.storage.PreferencesManager
import okhttp3.Interceptor
import okhttp3.Response


class HttpHeaderInterceptor(private val preferencesManager: PreferencesManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()

        val builder = request?.newBuilder()
        return chain?.proceed(builder?.build())!!
    }
}