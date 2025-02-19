package com.example.androidmodule1.exercise.classroom.ejercicio2edgar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmodule1.R


class FrameLActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_frame_lactivity)

        val btnOpenEdgarLayoutsActivity = findViewById<Button>(R.id.btRegresar)

        btnOpenEdgarLayoutsActivity.setOnClickListener {
            val frameActivity = Intent(this, EdgarLayoutsActivity::class.java)
            register.launch(frameActivity)
        }

    }
}