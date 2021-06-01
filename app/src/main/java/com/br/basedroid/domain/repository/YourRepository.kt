package com.br.basedroid.domain.repository

import com.br.basedroid.presentation.model.ObjectPresentation

interface YourRepository {

    suspend fun getExample(): Result<ObjectPresentation>
}