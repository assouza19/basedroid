package com.br.basedroid.data.retrofit

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

/*
* Esta classe é responsável por interceptar a chamada da API para implementar o cache de 10 minutos;
*/

const val CACHE_CONTROL_HEADER = "Cache-Control"
const val TEN_UNIT = 10

object CacheInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalResponse = chain.proceed(request)

        val cacheControl = CacheControl.Builder()
            .maxAge(TEN_UNIT, TimeUnit.MINUTES)
            .build()

        return originalResponse.newBuilder()
            .header(CACHE_CONTROL_HEADER, cacheControl.toString())
            .build()
    }
}