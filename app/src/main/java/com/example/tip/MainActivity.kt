package com.example.tip


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.tip.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val price: EditText = binding.price

        binding.button.setOnClickListener {

            OK()

        }

    }
    fun calc(price:Double , tipPercent:Double):Double{
        return ((price*tipPercent))
    }
    fun calulate(price: Double):Double{
        val tipPercent:Double = when (binding.rad.checkedRadioButtonId) {
            R.id.exc -> 0.020
            R.id.good -> 0.018
            else -> 0.015
        }
        binding.tipAmount.text = getString(R.string.tip_amount, (tipPercent*price).toString())
        return (price+calc(price, tipPercent))
    }
    fun OK(){
        val price = binding.price
        val cost = price.text.toString().toDoubleOrNull()
        if(cost == null) {
            binding.tipAmount.text = ""
            return
        }
        val percent = calulate(price.text.toString().toDouble())

        Toast.makeText(
            this, (percent).toString(), Toast.LENGTH_SHORT
        ).show()
    }
}