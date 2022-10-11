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

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val price: EditText = requireViewById(R.id.price)
        val button: Button = requireViewById(R.id.button)
        val radio: RadioGroup = requireViewById(R.id.rad)
        val selected: RadioButton = requireViewById(radio.checkedRadioButtonId)


        button.setOnClickListener {
            val res: Int = price.text.toString().toInt()
            val toast: Toast = Toast.makeText(this,
                res+(res/100*selected.text.toString().toInt())
                ,Toast.LENGTH_SHORT)
            toast.show()
//            val ts: Toast = Toast.makeText()
        }
    }
}