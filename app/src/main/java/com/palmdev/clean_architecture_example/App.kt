package com.palmdev.clean_architecture_example

import android.app.Application
import com.palmdev.clean_architecture_example.di.appModule
import com.palmdev.clean_architecture_example.di.dataModule
import com.palmdev.clean_architecture_example.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}