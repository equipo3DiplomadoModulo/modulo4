package com.example.androidmodule1.exercise.classroom

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
import com.example.androidmodule1.exercise.classroom.edgarIntent.EdgarActivity
import com.example.androidmodule1.exercise.classroom.luisTapia.MenuLuisActivity
import com.example.androidmodule1.exercise.classroom.luisTapia.ejercicio1.LuisActivity


class EquipoCuatroActivity : AppCompatActivity() {
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
        enableEdgeToEdge()
        setContentView(R.layout.activity_equipo_cuatro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpenEdgarViews = findViewById<Button>(R.id.btnOpenEdgarScreen)
        val btnOpenLuisViews = findViewById<Button>(R.id.btnOpenLuisScreen)

        btnOpenEdgarViews.setOnClickListener {
            val  secondIntent = Intent(this, EdgarActivity::class.java ).apply {
                putExtra("EXTRA_NAME","Vistas de Edgar")
            }
            register.launch(secondIntent)
        }


        btnOpenLuisViews.setOnClickListener {
            val luisIntent = Intent(this, MenuLuisActivity::class.java).apply {

            }

            register.launch(luisIntent)
        }






    }
}