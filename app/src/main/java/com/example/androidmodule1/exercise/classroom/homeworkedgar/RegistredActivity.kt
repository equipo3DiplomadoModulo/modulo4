package com.example.androidmodule1.exercise.classroom.homeworkedgar

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R

class RegistredActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registred)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       val tvSucces = findViewById<TextView>(R.id.tvSucces)
        intent.extras?.let{
            // it es la referencia a su intent , es parecido al this
            if(it.containsKey("EXTRA_NAME")){ // SI LA LLAVE EXISTE
                val name = it.getString("EXTRA_NAME")
                val sexText = it.getString("EXTRA_SEX")

                if( sexText == "H" ){
                    tvSucces.text = "$name fuiste registrado con exito"
                }else{
                    tvSucces.text = "$name fuiste registrada con exito"
                }
            }
        }
    }
}