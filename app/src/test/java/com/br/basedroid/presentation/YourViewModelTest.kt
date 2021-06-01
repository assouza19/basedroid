package com.br.basedroid.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.br.basedroid.domain.usecase.GetExampleUseCase
import com.br.basedroid.presentation.model.ObjectPresentation
import com.br.basedroid.utils.MainCoroutineRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import kotlin.Result.Companion.success
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class YourViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val useCase: GetExampleUseCase = mock()
    private val viewModel: YourViewModel by lazy {
        YourViewModel(useCase)
    }

    @Test
    fun `exampleCallCoroutines should call use case`() = runBlockingTest {
        // Given
        whenever(useCase.invoke()).thenAnswer { success(ObjectPresentation(id = "123")) }

        // When
        viewModel.exampleCallCoroutines()

        val response = viewModel.resultSuccess.value!!.isSuccess

        // Then
        verify(useCase).invoke()
        assertTrue(response)
    }
}
