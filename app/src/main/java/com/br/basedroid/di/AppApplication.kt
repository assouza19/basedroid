package com.br.basedroid.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(domainModules)
            modules(dataModules)
            modules(presentationModules)
            modules(networkModules)
            modules(anotherModules)
        }
    }
}