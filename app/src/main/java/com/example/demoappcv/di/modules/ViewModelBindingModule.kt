package com.example.demoappcv.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoappcv.di.DaggerViewModelFactory
import com.example.demoappcv.di.ViewModelKey
import com.example.demoappcv.ui.details.MovieDetailActivityViewModel
import com.example.demoappcv.ui.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBindingModule {

    @Binds
    internal abstract fun bindFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun mainViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailActivityViewModel::class)
    abstract fun localizationsViewModule(viewModel: MovieDetailActivityViewModel): ViewModel

}