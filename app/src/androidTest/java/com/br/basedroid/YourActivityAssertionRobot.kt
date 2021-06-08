package com.br.basedroid

import com.br.basedroid.utils.BaseRobot

fun check(func: YourActivityAssertionRobot.() -> Unit) =
    YourActivityAssertionRobot().apply { func() }

open class YourActivityAssertionRobot : BaseRobot() {

    fun titleIsVisible() {
        checkViewHasText(R.id.title, "Projeto base criado por: Aline Souza")
    }
}


