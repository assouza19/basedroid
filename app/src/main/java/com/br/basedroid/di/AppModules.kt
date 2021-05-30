package com.br.basedroid.di

import com.br.basedroid.data.retrofit.HttpClient
import com.br.basedroid.data.retrofit.RetrofitClient
import com.br.basedroid.data.api.YourService
import com.br.basedroid.data.datasource.RemoteDataSource
import com.br.basedroid.data.datasource.RemoteDataSourceImpl
import com.br.basedroid.data.repository.YourRepositoryImpl
import com.br.basedroid.domain.repository.YourRepository
import com.br.basedroid.domain.usecase.GetExampleUseCase
import com.br.basedroid.presentation.YourViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/*
* Neste arquivo você deve declarar todas as suas dependências injetadas.
* Lembre-se de manter cada classe em sua camada, como feito abaixo.
* Obs.: Se o arquivo ficar muito grande, é melhor criar um arquivo para cada camada.
*/

val domainModules = module {
    factory { GetExampleUseCase(repository = get()) }
}

val presentationModules = module {
    viewModel { YourViewModel(useCase = get()) }
}

val dataModules = module {
    factory<RemoteDataSource> { RemoteDataSourceImpl(api = get()) }
    factory<YourRepository> { YourRepositoryImpl(remoteDataSource = get()) }
}

val networkModules = module {
    single { RetrofitClient(application = androidContext()).newInstance() }
    single { HttpClient(get()) }
    factory { get<HttpClient>().create(YourService::class.java) }
}

val anotherModules = module {}
