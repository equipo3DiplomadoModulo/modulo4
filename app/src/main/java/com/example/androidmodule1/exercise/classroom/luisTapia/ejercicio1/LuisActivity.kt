package com.example.androidmodule1.exercise.classroom.luisTapia.ejercicio1

import android.content.Intent
import android.net.Uri
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
import com.example.androidmodule1.exercise.classroom.EquipoCuatroActivity
import com.example.androidmodule1.exercise.classroom.luisTapia.MenuLuisActivity
import com.google.android.material.internal.ManufacturerUtils

class LuisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val register =  registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if( result.resultCode == RESULT_OK ){

                val extraRetorno = result.data?.getStringExtra("EXTRA_RETURN_DATA")

                Toast.makeText(this, "$extraRetorno", Toast.LENGTH_LONG).show()

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
        val btnIntentGoogle = findViewById<Button>(R.id.btnIntentUrl)

        val btnSegundaPantalla = findViewById<Button>(R.id.btnOpenLuisSecondScreen)

        btnRegresarHome.setOnClickListener {

            val homeIntent = Intent(this, MenuLuisActivity::class.java)

            register.launch(homeIntent)

        }


        btnIntentGoogle.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW , Uri.parse("http://www.google.com"))

            startActivity(Intent.createChooser(urlIntent,"Abrir usando:"))
        }


        btnSegundaPantalla.setOnClickListener {

            val pantallaDosIntent = Intent(this , LuisSecondActivity::class.java ).apply {
                putExtra("EXTRA_NOMBRE","LUIS TAPIA")
                putExtra("EXTRA_ACTIVIDAD","PRIMER EJERCICIO"
                )
            }


            register.launch(pantallaDosIntent)

        }


    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Estatus: onStart",Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()

        Log.e("LifeCycle","onResume")
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG)
            .show()
    }

    override fun onPause() {
        super.onPause()
        Log.e("LifeCycle","Estatus: onPause")
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG)
            .show()
    }

    override fun onStop() {
        super.onStop()
        Log.e("LifeCycle","Estatus: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LifeCycle","Estatus: onDestroy")
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG)
            .show()
    }
}