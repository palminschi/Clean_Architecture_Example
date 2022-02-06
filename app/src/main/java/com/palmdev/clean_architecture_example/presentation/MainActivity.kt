package com.palmdev.clean_architecture_example.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.palmdev.clean_architecture_example.databinding.ActivityMainBinding
import com.palmdev.data.repository.UserRepositoryImpl
import com.palmdev.domain.models.SaveUserNameParam
import com.palmdev.domain.usecases.GetDataUseCase
import com.palmdev.domain.usecases.SaveDataUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy { UserRepositoryImpl(applicationContext) }
    private val saveDataUseCase by lazy { SaveDataUseCase(userRepository) }
    private val getDataUseCase by lazy { GetDataUseCase(userRepository) }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnGetData.setOnClickListener {
            val data = getDataUseCase.execute()
            binding.tvUserData.text = data.firstName + data.lastName
        }

        binding.btnSaveData.setOnClickListener {
            val userFirstName = binding.editTextFirstName.text.toString()
            val userLastName = binding.editTextLastName.text.toString()

            val params = SaveUserNameParam(firstName = userFirstName, lastName = userLastName)

            saveDataUseCase.execute(params)
        }
    }
}