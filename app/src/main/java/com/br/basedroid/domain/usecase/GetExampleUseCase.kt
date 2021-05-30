package com.br.basedroid.domain.usecase

import com.br.basedroid.domain.repository.YourRepository

/*
* Esta classe é responsável por realizar os casos de uso, chamando seu repository.
* Deve-se ter um UseCase para cada ação do seu aplicativo.
* Exemplo: Se seu aplicativo pode salvar dados, excluir dados e pegar dados,
* então, deverá ter 3 classes UseCase distintos.
*
*/

class GetExampleUseCase(
    private val repository: YourRepository
) {

    suspend operator fun invoke() = repository.getExample()
}