package com.example.securekeys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var apiKey = BuildConfig.GOOGLE_MAPS_API_KEY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This prints the key to check
        Log.d("MAIN_API_KEY", apiKey)
    }
}