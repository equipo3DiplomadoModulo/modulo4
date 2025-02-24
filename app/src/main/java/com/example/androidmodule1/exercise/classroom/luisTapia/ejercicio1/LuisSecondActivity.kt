package com.example.androidmodule1.exercise.classroom.luisTapia.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R

class LuisSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_luis_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<TextView>(R.id.tvNombre)
        val tvActivity = findViewById<TextView>(R.id.tvNombreActividad)
        val btnRegresar = findViewById<Button>(R.id.btRegresar)
        //EXTRA_NOMBRE
        //EXTRA_ACTIVIDAD

        val nombre = intent.getStringExtra("EXTRA_NOMBRE")

        nombre?.let { nombreValidado ->
            tvName.text = nombreValidado
        }


        val actividad = intent.getStringExtra("EXTRA_ACTIVIDAD")

        actividad?.let { actividadValidada ->

            tvActivity.text = actividadValidada
        }


        btnRegresar.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_RETURN_DATA", "Información de retorno")
            }

            setResult( RESULT_OK,  resultIntent)
            finish()

        }


    }
}