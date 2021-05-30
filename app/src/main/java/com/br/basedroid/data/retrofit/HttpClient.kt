package com.br.basedroid.data.retrofit

import retrofit2.Retrofit

/*
* Essa classe foi criada no intuito de que o retrofit pudesse ser injetado pelo Koin usando Singleton
* (ver doc sobre Koin), poupando que fosse criado uma nova instância do mesmo cada vez que uma API
* fosse chamada. Desta forma, o código também fica desacoplado da chamada do Serviço.
*
*/

class HttpClient(private val retrofit: Retrofit) {

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}