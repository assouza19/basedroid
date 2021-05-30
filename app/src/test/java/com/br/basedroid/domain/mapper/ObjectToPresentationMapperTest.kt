package com.br.basedroid.domain.mapper

import com.br.basedroid.domain.model.ObjectDomain
import com.br.basedroid.presentation.model.ObjectPresentation
import org.junit.Test
import kotlin.test.assertEquals

class ObjectToPresentationMapperTest {

    private val mapper: ObjectToPresentationMapper = ObjectToPresentationMapper()

    @Test
    fun `when mapper should map to presentation`() {
        // When
        val result = mapper.map(ObjectDomain(id = "123"))

        // Then
        assertEquals(result, ObjectPresentation(id = "123"))
    }
}