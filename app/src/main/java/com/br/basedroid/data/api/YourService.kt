package com.br.basedroid.data.api

import com.br.basedroid.data.model.ExampleResponse
import retrofit2.http.GET

/*
* Esta classe é responsável por conter seus métodos
* de chamada da API (métodos GET, POST, PATCH, etc);
*/

interface YourService {

    @GET("/endpoint/example")
    suspend fun getExample(): ExampleResponse
}