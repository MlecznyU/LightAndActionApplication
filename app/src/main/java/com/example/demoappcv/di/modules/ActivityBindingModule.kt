package com.example.demoappcv.di.modules

import com.example.demoappcv.di.ActivityScoped
import com.example.demoappcv.ui.details.MovieDetailActivity
import com.example.demoappcv.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun movieDetailActivity(): MovieDetailActivity
}