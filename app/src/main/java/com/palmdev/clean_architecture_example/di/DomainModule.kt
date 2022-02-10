package com.palmdev.clean_architecture_example.di

import com.palmdev.domain.usecases.GetDataUseCase
import com.palmdev.domain.usecases.SaveDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<SaveDataUseCase> {
        SaveDataUseCase( userRepository = get() )
    }

    factory<GetDataUseCase> {
        GetDataUseCase( userRepository = get() )
    }
}