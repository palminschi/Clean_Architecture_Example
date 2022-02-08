package com.palmdev.clean_architecture_example.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.palmdev.domain.models.SaveUserNameParam
import com.palmdev.domain.usecases.GetDataUseCase
import com.palmdev.domain.usecases.SaveDataUseCase

class MainViewModel(
    private val saveDataUseCase: SaveDataUseCase,
    private val getDataUseCase: GetDataUseCase): ViewModel()
{

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive : LiveData<String> = resultLiveMutable

    init {
        Log.d("AAA", "ViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("AAA", "ViewModel cleared")
    }

    fun saveData(firstName: String, lastName: String){
        val params = SaveUserNameParam(firstName = firstName, lastName = lastName)
        saveDataUseCase.execute(params)
    }

    fun getData() {
        val data = getDataUseCase.execute()
        resultLiveMutable.value = data.firstName + data.lastName
    }
}