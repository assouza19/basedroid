package com.br.basedroid.data.mapper

import com.br.basedroid.data.model.ExampleResponse
import com.br.basedroid.domain.model.ObjectDomain
import com.br.basedroid.utils.Mapper

/*
* Esta classe transforma um objeto da camada de DATA para um objeto da camada de DOMAIN.
* Lembre-se: Quanto mais isoladas suas camadas forem, maior sua
* flexibilidade para realizar mudanças sem gerar grandes impactos.
*/

class ObjectToDomainMapper: Mapper<ExampleResponse, ObjectDomain> {

    override fun map(source: ExampleResponse): ObjectDomain {
        return ObjectDomain(
            id = source.id
        )
    }
}