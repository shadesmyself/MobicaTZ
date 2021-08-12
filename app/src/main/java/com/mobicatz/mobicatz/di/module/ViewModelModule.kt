package com.mobicatz.mobicatz.di.module

import com.mobicatz.mobicatz.domain.GetMobicaApiUseCase
import com.mobicatz.mobicatz.ui.homepage.vm.FragmentHomePageViewModel
import dagger.Module
import dagger.Provides
@Module
class ViewModelModule {
    @Provides
    fun provideHomePageViewModel(mobicaApiUseCase: GetMobicaApiUseCase): FragmentHomePageViewModel {
        return FragmentHomePageViewModel(mobicaApiUseCase)
    }
}