package com.br.basedroid.data.datasource

import com.br.basedroid.data.repository.YourRepositoryImpl
import com.br.basedroid.domain.model.ObjectDomain
import com.br.basedroid.domain.repository.YourRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class RemoteDataSourceTest {

    private val dataSource: RemoteDataSource = mock()

    private val repository: YourRepository by lazy {
        YourRepositoryImpl(dataSource)
    }

    @Test
    fun `When get from remote data source should return success`() = runBlockingTest {
        // Given
        whenever(dataSource.getExample()).thenReturn(ObjectDomain(id = "12"))

        // When
        val result = repository.getExample()

        // Then
        verify(dataSource).getExample()
        assertEquals("12", result.getOrNull()!!.id)
    }
}