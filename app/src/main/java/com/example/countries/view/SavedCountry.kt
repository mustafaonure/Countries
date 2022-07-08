package com.example.countries.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countries.R
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.databinding.ActivitySavedCountryBinding

class SavedCountry : AppCompatActivity() {

    lateinit var binding: ActivitySavedCountryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}