package com.mobicatz.mobicatz.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val application: Context) {
    @Provides
    fun provideApplicationContext(): Context = application

}