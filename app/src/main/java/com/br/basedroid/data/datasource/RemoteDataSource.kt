package com.br.basedroid.data.datasource

import com.br.basedroid.domain.model.ObjectDomain

interface RemoteDataSource {

    suspend fun getExample(): ObjectDomain
}