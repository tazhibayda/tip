package com.example.tip

import android.app.ProgressDialog.show
import android.content.res.Resources
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
import java.text.NumberFormat

//import com.example.tip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val price: EditText = findViewById(R.id.price)
        val button: Button = findViewById(R.id.button)
        val radio: RadioGroup = findViewById(R.id.rad)

        button.setOnClickListener {
            if (price.text.isEmpty()){
                Toast.makeText(this,"Empty cost", Toast.LENGTH_SHORT).show()
            }else {
                val percent = when (radio.checkedRadioButtonId) {
                            R.id.exc -> 0.20
                            R.id.good -> 0.18
                            else -> 0.15
                        }
                val priceVal = price.text.toString().toDouble()
                binding.tipAmount.text = getString(R.string.tip_amount, price.text)
                Toast.makeText(
                    this, (priceVal + calc(priceVal,percent)).toString(), Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
    fun calc(price:Double , tipPercent:Double):Double{
        return ((price*tipPercent))
    }
}