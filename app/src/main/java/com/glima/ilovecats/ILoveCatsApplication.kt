package com.glima.ilovecats

import android.app.Application
import com.glima.data.di.DataModule.dataModule
import com.glima.domain.di.DomainModule.domainModule
import com.glima.ilovecats.di.AppModule.appModule
import com.glima.ilovecats.di.PresentationModule.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ILoveCatsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ILoveCatsApplication)
            modules(
                listOf(
                    appModule,
                    presentationModule,
                    dataModule,
                    domainModule
                )
            )
        }
    }
}