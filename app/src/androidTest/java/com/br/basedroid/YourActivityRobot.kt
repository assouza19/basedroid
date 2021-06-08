package com.br.basedroid

import android.content.Intent
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest

/*
* Essa classe é responsável por preparar o ambiente para que seu teste rode.
* Por exemplo, se precisar mockar algo ou incluir mais cenários de resposta da API.
 */
private const val serverPort = 8080

fun onActivity(func: YourActivityRobot.() -> Unit) = YourActivityRobot().apply { func() }

class YourActivityRobot : YourActivityAssertionRobot() {

    private val server = MockWebServer()

    fun setUp() {
        server.start(serverPort)

        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return when (request.path) {

                    "your/path/endpoint" -> {
                        successResponse
                    }
                    else -> {
                        errorResponse
                    }
                }
            }
        }
    }

    fun launch() {
        activityRule.launchActivity(Intent())
    }

    companion object {
        private val successResponse by lazy {
            MockResponse()
                .setResponseCode(200)
                .setBody("PUT HERE YOUR SUCCESS JSON RESPONSE")
        }

        private val errorResponse by lazy { MockResponse().setResponseCode(503) }
    }
}