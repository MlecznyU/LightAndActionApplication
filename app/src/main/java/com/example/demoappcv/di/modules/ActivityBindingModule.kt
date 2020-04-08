package com.example.demoappcv.di.modules

import com.example.demoappcv.di.ActivityScoped
import com.example.demoappcv.ui.main.MainActivity
import com.example.demoappcv.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

}