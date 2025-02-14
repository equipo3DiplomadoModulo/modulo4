package com.example.androidmodule1.exercise.classroom.luisTapia.ejercicio2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R
import com.example.androidmodule1.exercise.classroom.luisTapia.MenuLuisActivity

class LuisEjercicio2Activity : AppCompatActivity() {
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
        setContentView(R.layout.activity_luis_ejercicio_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMenuLuis = findViewById<Button>(R.id.btnRegresarHomeScren)

        val btnFrameLayout = findViewById<Button>(R.id.btFrameLayout)
        val btnLinearLayout = findViewById<Button>(R.id.btLinearLayout)
        val btnRelativeLayout = findViewById<Button>(R.id.btRelativeLayout)


        btnFrameLayout.setOnClickListener {
            val frameLayoutIntent = Intent(this , FrameLayoutActivity::class.java)

            register.launch(frameLayoutIntent)
        }

        btnLinearLayout.setOnClickListener {
            val linearLayoutIntent = Intent(this , LuisLinearLayoutActivity::class.java)

            register.launch(linearLayoutIntent)
        }

        btnRelativeLayout.setOnClickListener {
            val relativeLayoutIntent = Intent(this , LuisRelativeLayoutActivity::class.java)

            register.launch(relativeLayoutIntent)
        }

        btnMenuLuis.setOnClickListener {
            val menuPrincipalInten = Intent(this, MenuLuisActivity::class.java)

            register.launch(menuPrincipalInten)


        }


    }


}