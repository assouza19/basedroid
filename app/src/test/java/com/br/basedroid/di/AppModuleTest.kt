package com.br.basedroid.di

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class AppModulesTest : KoinTest {

    @get:Rule
    val localTestRule: LocalTestRule = LocalTestRule()

    @Before
    fun setUp() {
        startKoin {}
    }

    @Test
    fun `load should provide dependencies on Koin when is called`() {
        koinApplication {
            listOf(
                domainModules,
                presentationModules,
                dataModules,
                networkModules,
                anotherModules
            )
        }.checkModules()
    }

    @After
    fun autoClose() {
        stopKoin()
    }
}

class LocalTestRule : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return RuleChain
            .outerRule(InstantTaskExecutorRule())
            .apply(base, description)
    }
}