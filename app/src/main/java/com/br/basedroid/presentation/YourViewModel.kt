package com.br.basedroid.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.basedroid.domain.usecase.GetExampleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
* Esta classe tem por objetivo conter sua lógica de apresentação.
* Por exemplo, se o texto apresentado será X ou Y, realizar a chamada Coroutines,
* e fornecer os dados formatados para sua View.
*
* Obs1.: É de extrema importância que sua lógica fique acoplada aqui e não na sua Activity.
* Costumamos dizer que sua View deve ser o mais "burra" possível, ou seja, só mostrar/ocultar os dados.
*
* Obs2.: Este projeto está utilizando Coroutines para realizar as chamadas assíncronas.
* É de extrema importância entender sua utilização, opções de threads (por exemplo, utilizei o
* Dispatchers.IO abaixo) e qual o impacto de sua utilização em seu app.
*
*/

class YourViewModel(
    private val useCase: GetExampleUseCase
) : ViewModel() {

    private val _resultSuccess = MutableLiveData<Result<Boolean>>().apply { value = Result.success(false) }

    val resultSuccess : LiveData<Result<Boolean>>
        get() = _resultSuccess

    fun exampleCallCoroutines() {

        viewModelScope.launch(Dispatchers.IO) {

            runCatching {
                useCase()
            }.onSuccess {

                // Do something case successful
                _resultSuccess.postValue(Result.success(true))

            }.onFailure {

                // Do something case failure
                _resultSuccess.postValue(Result.failure(it))

            }
        }
    }
}