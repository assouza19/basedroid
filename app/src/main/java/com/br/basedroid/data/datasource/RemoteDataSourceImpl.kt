package com.br.basedroid.data.datasource

import com.br.basedroid.data.api.YourService
import com.br.basedroid.data.mapper.ObjectToDomainMapper

/*
* Esta classe é responsável por chamar a API.
* Como o resultado é retornado um objeto da camada de DATA, já
* é realizado o map para retornar um objeto da camada de DOMAIN.
*
* Obs.: Muita gente prefere injetar o Mapper direto no construtor, para
* aproveitar o uso do Koin. Esse ponto é válido de discussão.
*
*/

class RemoteDataSourceImpl(
    private val api: YourService
) : RemoteDataSource {

    private val mapper: ObjectToDomainMapper = ObjectToDomainMapper()

    override suspend fun getExample() = mapper.map(api.getExample())
}
