package com.br.basedroid.domain.usecase

import com.br.basedroid.domain.repository.YourRepository
import com.br.basedroid.presentation.model.ObjectPresentation
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class GetExampleUseCaseTest {
    private val repository: YourRepository = mock()
    private val useCase: GetExampleUseCase = GetExampleUseCase(repository)

    @Test
    fun `when invoke should return success`() = runBlockingTest {
        // Given
        whenever(repository.getExample()).thenReturn(ObjectPresentation(id = "123"))

        // When
        val result = useCase.invoke()

        // Then
        assertEquals(result, ObjectPresentation(id = "123"))
    }
}