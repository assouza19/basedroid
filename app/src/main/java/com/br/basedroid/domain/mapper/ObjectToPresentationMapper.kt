package com.br.basedroid.domain.mapper

import com.br.basedroid.domain.model.ObjectDomain
import com.br.basedroid.presentation.model.ObjectPresentation
import com.br.basedroid.utils.Mapper

class ObjectToPresentationMapper: Mapper<ObjectDomain, ObjectPresentation> {

    override fun map(source: ObjectDomain): ObjectPresentation {
        return ObjectPresentation(
            id = source.id
        )
    }
}