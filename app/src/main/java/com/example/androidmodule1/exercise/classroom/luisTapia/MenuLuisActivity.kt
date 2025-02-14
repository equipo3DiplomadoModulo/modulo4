package com.example.androidmodule1.exercise.classroom.luisTapia

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
import com.example.androidmodule1.exercise.classroom.luisTapia.ejercicio1.LuisActivity
import com.example.androidmodule1.exercise.classroom.luisTapia.ejercicio2.LuisEjercicio2Activity

class MenuLuisActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_menu_luis)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMenuPrincipal = findViewById<Button>(R.id.btnRegresarHomeScren)
        val btnEjercicio1 = findViewById<Button>(R.id.btEjercicio1)
        val btnEjercicio2 = findViewById<Button>(R.id.btEjercicio2)


        btnMenuPrincipal.setOnClickListener {
            val menuPrincipalIntent = Intent(this, EquipoCuatroActivity::class.java)

            register.launch(menuPrincipalIntent)
        }


        btnEjercicio1.setOnClickListener {
            val ejercicio1Intent = Intent(this , LuisActivity::class.java)

            register.launch(ejercicio1Intent)
        }


        btnEjercicio2.setOnClickListener {

            val ejercico2Intent = Intent(this, LuisEjercicio2Activity::class.java )

            register.launch(ejercico2Intent)

        }





    }
}