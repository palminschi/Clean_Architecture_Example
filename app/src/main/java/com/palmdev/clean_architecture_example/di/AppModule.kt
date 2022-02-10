package com.palmdev.clean_architecture_example.di

import com.palmdev.clean_architecture_example.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            saveDataUseCase = get(),
            getDataUseCase = get()
        )
    }
}