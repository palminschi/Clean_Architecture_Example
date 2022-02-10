package com.palmdev.clean_architecture_example.di

import com.palmdev.data.repository.UserRepositoryImpl
import com.palmdev.data.storage.SharedPrefsUserStorage
import com.palmdev.data.storage.UserStorage
import com.palmdev.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefsUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}