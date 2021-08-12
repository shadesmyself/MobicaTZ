package com.mobicatz.mobicatz.di.module

import android.content.Context
import com.mobicatz.mobicatz.data.remote.NetworkDatabaseDataSource
import com.mobicatz.mobicatz.data.remote.NetworkDatabaseDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkDatabaseDataSourceModule {
    @Provides
    fun provideMobicaNetworkDatabaseDataSource(context: Context) : NetworkDatabaseDataSource{
        return NetworkDatabaseDataSourceImpl(context)
    }
}