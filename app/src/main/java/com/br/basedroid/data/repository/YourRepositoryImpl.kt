package com.br.basedroid.data.repository

import com.br.basedroid.data.datasource.RemoteDataSource
import com.br.basedroid.domain.mapper.ObjectToPresentationMapper
import com.br.basedroid.domain.repository.YourRepository
import com.br.basedroid.presentation.model.ObjectPresentation

/*
* Esta camada é responsável por chavear entre as fontes de dados.
* Por exemplo, se você tivesse armazenamento local (usando ROOM, por exemplo),
* você teria um localDataSource, e este repository seria responsável pela
* lógica de saber se pega os dados localmente ou da API.
*
* Após a chamada, é realizado a transformação do objeto da camada de DOMAIN
* para um objeto da camada de PRESENTATION por meio do mapper.
*
*/

class YourRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : YourRepository {

    private val mapper: ObjectToPresentationMapper = ObjectToPresentationMapper()

    override suspend fun getExample(): Result<ObjectPresentation> {
        // retorne Result.failure em caso de alguma falha
        return Result.success(mapper.map(remoteDataSource.getExample()))
    }
}