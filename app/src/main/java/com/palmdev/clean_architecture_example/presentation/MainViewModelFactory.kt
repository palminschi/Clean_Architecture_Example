package com.palmdev.clean_architecture_example.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.palmdev.data.repository.UserRepositoryImpl
import com.palmdev.data.storage.SharedPrefsUserStorage
import com.palmdev.domain.usecases.GetDataUseCase
import com.palmdev.domain.usecases.SaveDataUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context)) }
    private val saveDataUseCase by lazy { SaveDataUseCase(userRepository) }
    private val getDataUseCase by lazy { GetDataUseCase(userRepository) }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveDataUseCase = saveDataUseCase,
            getDataUseCase = getDataUseCase
        ) as T
    }
}