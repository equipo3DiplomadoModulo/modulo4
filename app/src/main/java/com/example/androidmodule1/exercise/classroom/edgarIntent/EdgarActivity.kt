package com.example.androidmodule1.exercise.classroom.edgarIntent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R
import com.example.androidmodule1.exercise.classroom.explicitIntent.SecondActivity

class EdgarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

         val register =  registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if( result.resultCode == RESULT_OK ){

                val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT",  false)

                Toast.makeText(this, "El dato de 2do activity fue: ${isCorrect} ", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "CANCELLED", Toast.LENGTH_LONG).show()
            }
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edgar)


        Toast.makeText(this,"Estatus: onCreate",Toast.LENGTH_SHORT)
            .show()

       val btnOpenEdgarSecondView = findViewById<Button>(R.id.btnOpenEdgarSecondScreen)

        btnOpenEdgarSecondView.setOnClickListener{

            val  secondIntent = Intent(this, EdgarSecondActivity::class.java ).apply {
                putExtra("EXTRA_NAME","Info desde 1er Activity de Edgar ")

            }

            register.launch(secondIntent)
        }


        val btnIrURL = findViewById<Button>(R.id.btnIrURL)
        btnIrURL.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW , Uri.parse("http://www.italiannis.com.mx"))

            startActivity(Intent.createChooser(urlIntent,"Abrir usando:"))
        }


    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Estatus: onStart",Toast.LENGTH_SHORT).show()
    }
}