package com.mobicatz.mobicatz.di.components

import android.content.Context
import com.mobicatz.mobicatz.di.module.*
import com.mobicatz.mobicatz.ui.homepage.ui.FragmentHomePage
import dagger.Component
import javax.inject.Singleton

@Component (modules = [NetworkDatabaseDataSourceModule::class, MobicaApiRepositoryModule::class, ViewModelModule::class, UseCaseModule::class, ContextModule::class])
interface AppComponent {

   fun context(): Context
   fun inject(fragment: FragmentHomePage)

}