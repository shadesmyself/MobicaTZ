package com.mobicatz.mobicatz.di.module

import com.mobicatz.mobicatz.data.remote.NetworkDatabaseDataSource
import com.mobicatz.mobicatz.data.repository.MobicaApiRepository
import com.mobicatz.mobicatz.data.repository.MobicaApiRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class MobicaApiRepositoryModule {

    @Provides
    fun provideMobicaRepository(context: NetworkDatabaseDataSource): MobicaApiRepository{
        return MobicaApiRepositoryImpl(context)
    }
}