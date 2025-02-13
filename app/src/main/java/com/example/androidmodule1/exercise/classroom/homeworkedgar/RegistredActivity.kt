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
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        var secondname = "x"
        var email = ""
        intent.extras?.let{

            if(it.containsKey("EXTRA_SECONDNAME")) {
               secondname = it.getString("EXTRA_SECONDNAME").toString()
            }
            if(it.containsKey("EXTRA_EMAIL")) {
                email = it.getString("EXTRA_EMAIL").toString()
            }

            if(it.containsKey("EXTRA_NAME")){
                val name = it.getString("EXTRA_NAME")

                val sexText = it.getString("EXTRA_SEX")

                // diferenciador de genero en el mensaje bajo sexo elegido
                if( sexText == "H" ){
                    tvSucces.text = "$name $secondname  fuiste registrado exitosamente con el correo:"

                }else{
                    tvSucces.text = "$name $secondname fuiste registrada exitosamente con el correo:"
                }
                    tvEmail.text = email
            }
        }
    }
}