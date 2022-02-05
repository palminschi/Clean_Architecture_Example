package com.palmdev.clean_architecture_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.palmdev.clean_architecture_example.databinding.ActivityMainBinding
import com.palmdev.domain.MyClass

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}