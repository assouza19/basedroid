package com.br.basedroid

import com.br.basedroid.utils.BaseRobot

/*
* Esta é a classe responsável por realizar os seus Assertions, ou seja,
* validar se a sua view está mostrando o cenário esperado.
* Caso você precise fazer um click na tela, por exemplo, o ideal é criar uma classe
* separada, chamada `YourActivityActionRobot`, por exemplo.
*
* Dessa forma, as responsabilidades ficarão bem separadas.
*/
fun check(func: YourActivityAssertionRobot.() -> Unit) =
    YourActivityAssertionRobot().apply { func() }

open class YourActivityAssertionRobot : BaseRobot() {

    fun titleIsVisible() {
        checkViewHasText(R.id.title, "Projeto base criado por: Aline Souza")
    }
}


