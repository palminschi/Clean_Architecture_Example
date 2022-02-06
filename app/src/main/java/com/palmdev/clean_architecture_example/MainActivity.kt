package com.palmdev.clean_architecture_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.palmdev.clean_architecture_example.databinding.ActivityMainBinding
import com.palmdev.domain.usecases.GetDataUseCase
import com.palmdev.domain.usecases.SaveDataUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val saveDataUseCase = SaveDataUseCase()
        val getDataUseCase = GetDataUseCase()

        binding.btnGetData.setOnClickListener {
            val data = getDataUseCase.execute()
            // binding.tvUserData.text = data
        }

        binding.btnSaveData.setOnClickListener {
            val data = binding.editText.text.toString()
            // saveDataUseCase.execute(data)
        }
    }
}