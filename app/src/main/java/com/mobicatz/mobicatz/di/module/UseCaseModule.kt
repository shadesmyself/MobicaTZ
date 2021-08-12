package com.mobicatz.mobicatz.di.module

import com.mobicatz.mobicatz.data.repository.MobicaApiRepository
import com.mobicatz.mobicatz.domain.GetMobicaApiUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideMobicaUseCase(repository: MobicaApiRepository): GetMobicaApiUseCase{
        return GetMobicaApiUseCase(repository)
    }
}