package io.keepcoding.todo.ui

import android.app.Application
import com.facebook.stetho.Stetho
import io.keepcoding.todo.di.koin.appModule
import org.koin.android.ext.android.startKoin

class TodoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules = listOf(appModule))

        Stetho.initializeWithDefaults(this)
    }

}