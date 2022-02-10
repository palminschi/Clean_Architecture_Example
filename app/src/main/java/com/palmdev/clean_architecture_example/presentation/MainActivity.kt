package com.palmdev.clean_architecture_example.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.palmdev.clean_architecture_example.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val vm : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("AAA", "MainActivity created")

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