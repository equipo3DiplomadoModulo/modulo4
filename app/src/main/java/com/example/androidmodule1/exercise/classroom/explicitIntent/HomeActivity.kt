package com.example.androidmodule1.exercise.classroom.explicitIntent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R

class HomeActivity : AppCompatActivity() {

    private val register =  registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
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
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpenSecondView = findViewById<Button>(R.id.btnOpenSecondScreen)

        btnOpenSecondView.setOnClickListener {
            val  secondIntent = Intent(this, SecondActivity::class.java ).apply {
                putExtra("EXTRA_NAME","Luis Tapia")
                putExtra("EXTRA_MARRIED",false)
                putExtra("EXTRA_AGE",26)
            }
            register.launch(secondIntent)
        }
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Estatus: onStart",Toast.LENGTH_LONG).show()
    }
}