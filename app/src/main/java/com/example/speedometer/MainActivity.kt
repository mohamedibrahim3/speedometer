package com.example.speedometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.speedometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var needle: ImageView
    private val minValue = 0
    private val maxValue = 21.5
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        needle = binding.gaugeNeedle
        binding.button.setOnClickListener {
            updateGauge(30)
        }

    }
    private fun updateGauge(value: Int) {
        var flag = false
        if(value > maxValue) {
            flag = true
        }
        if(flag){
            val rotation1 = (30f - minValue) * 180f / (maxValue - minValue)
            needle.rotation = rotation1.toFloat()
        }
        else {
            val rotation = (value - minValue) * 180f / (maxValue - minValue)
            needle.rotation = rotation.toFloat()
        }
    }
}