package com.example.androidmodule1.exercise.classroom.luisTapia.ejercicio1

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
import com.example.androidmodule1.exercise.classroom.EquipoCuatroActivity
import com.example.androidmodule1.exercise.classroom.luisTapia.MenuLuisActivity
import com.google.android.material.internal.ManufacturerUtils

class LuisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val register =  registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if( result.resultCode == RESULT_OK ){

                val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT",  false)

                Toast.makeText(this, "IsCorrect: ${isCorrect} ", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "CANCELLED", Toast.LENGTH_LONG).show()
            }
        }


        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_luis)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnRegresarHome = findViewById<Button>(R.id.btnRegresarHomeScren)

        btnRegresarHome.setOnClickListener {

            val homeIntent = Intent(this, MenuLuisActivity::class.java)

            register.launch(homeIntent)

        }


    }
}