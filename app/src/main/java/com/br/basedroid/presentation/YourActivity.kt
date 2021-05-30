package com.br.basedroid.presentation

/**
 * Este projeto tem por objetivo servir como base de estudos para quem está aprendendo
 * sobre MVVM e Clean Architecture.
 *
 * Toda a arquitetura aqui apresentada visa seguir os padrões de SOLID e código limpo.
 *
 * Reservo-me no direito de corrigir pequenos ajustes que se façam necessários.
 *
 * @author Aline Souza
 * Criado em Maio de 2021
 *
 * Dúvidas e/ou sugestões? linkedin.com/in/assouza94
 */

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.basedroid.R
import com.br.basedroid.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class YourActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: YourViewModel by viewModel() // Injetando a viewModel

    /*
    * ATENÇÃO: Por mais fácil que seja, o uso do synthetics foi deprecado pela própria Google e
    * por esse motivo este projeto está usando ViewBinding. Mas fica ao seu critério usar outra abordagem
    * caso prefira (por exemplo, DataBinding). Apenas certifique-se de ver os prós e contras de cada.
     */
    private val viewBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewModel.exampleCallCoroutines()
    }
}