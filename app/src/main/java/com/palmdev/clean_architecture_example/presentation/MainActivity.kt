package com.palmdev.clean_architecture_example.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.palmdev.clean_architecture_example.databinding.ActivityMainBinding
import com.palmdev.data.repository.UserRepositoryImpl
import com.palmdev.data.storage.SharedPrefsUserStorage
import com.palmdev.domain.models.SaveUserNameParam
import com.palmdev.domain.usecases.GetDataUseCase
import com.palmdev.domain.usecases.SaveDataUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("AAA", "MainActivity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        vm.resultLive.observe(this) {
            binding.tvUserData.text = it
        }
        binding.btnGetData.setOnClickListener {
            vm.getData()
        }

        binding.btnSaveData.setOnClickListener {
            val userFirstName = binding.editTextFirstName.text.toString()
            val userLastName = binding.editTextLastName.text.toString()

            vm.saveData(userFirstName, userLastName)
        }
    }
}