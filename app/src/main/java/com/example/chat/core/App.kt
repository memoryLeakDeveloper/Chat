package com.example.chat.core

import android.app.Application
import com.example.chat.di.appModule
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }

    companion object {
        val chatReference = Firebase.firestore.collection("chat").document("main")
    }
}