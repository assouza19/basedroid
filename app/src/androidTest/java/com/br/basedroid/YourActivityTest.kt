package com.br.basedroid

import org.junit.Test

class YourActivityTest {

    @Test
    fun checkTitleIsVisible() {
        onActivity {
            setUp()
            launch()
        }
        check {
            titleIsVisible()
        }
    }
}