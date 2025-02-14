package com.example.androidmodule1.exercise.classroom.luisTapia.ejercicio2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R

class LuisRelativeLayoutActivity : AppCompatActivity() {

    val register =  registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if( result.resultCode == RESULT_OK ){

            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT",  false)

            Toast.makeText(this, "IsCorrect: ${isCorrect} ", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_LONG).show()
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_luis_relative_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnRegresarEjercio2 = findViewById<Button>(R.id.btnRegresarEjercicio2)

        btnRegresarEjercio2.setOnClickListener {

            val regresarEjercicio2Intent = Intent(this, LuisEjercicio2Activity::class.java )

            register.launch(regresarEjercicio2Intent)

        }

    }
}