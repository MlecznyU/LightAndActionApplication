package com.example.demoappcv.di

import android.app.Application
import com.example.demoappcv.LightAndActionApplication
import com.example.demoappcv.di.modules.ActivityBindingModule
import com.example.demoappcv.infrastructure.network.RetrofitModule
import com.example.demoappcv.infrastructure.room.module.RoomModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        RoomModule::class,
        RetrofitModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<LightAndActionApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}