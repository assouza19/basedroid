package com.br.basedroid.data.api

import retrofit2.Retrofit

class HttpClient(private val retrofit: Retrofit) {

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

    inline fun <reified T : Any> create(): T {
        return create(T::class.java)
    }
}