package com.example.tip

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.tip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val price: EditText = findViewById(R.id.price)
        val button: Button = findViewById(R.id.button)
        val radio: RadioGroup = findViewById(R.id.rad)
        binding = ActivityMainBinding.inflate(layoutInflater)
        button.setOnClickListener {
            Toast.makeText(this, (price.text.toString().toDouble() + calc(price.text.toString().toInt(), when(radio.checkedRadioButtonId){
                R.id.exc -> 0.20
                R.id.good -> 0.18
                else -> 0.15
            })).toString(), Toast.LENGTH_SHORT).show()
            binding.tipAmount.text = getString(R.string.tip_amount,price)
        }
    }
    fun calc(price:Int , tipPercent:Double):Double{
        return ((price*tipPercent))
    }
}