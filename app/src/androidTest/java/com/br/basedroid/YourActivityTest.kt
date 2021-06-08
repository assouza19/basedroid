package com.br.basedroid

import org.junit.Test

/*
 * Esta classe é responsável por conter todos os seus cenários de testes.
 * Lembre-se: É imprescindível que o nome dos seus testes descrevam exatamente
 * o que o teste está validando. Lemebre-se também que o ideal é que cada teste
 * valide um único cenário, para que, em caso de falha, seja mais fácil identificar o motivo.
 */


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