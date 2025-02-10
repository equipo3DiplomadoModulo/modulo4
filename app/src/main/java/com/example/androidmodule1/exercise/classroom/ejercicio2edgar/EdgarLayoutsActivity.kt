package com.example.androidmodule1.exercise.classroom.ejercicio2edgar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R

class EdgarLayoutsActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edgar_layouts)

        val btnOpenFrameL = findViewById<Button>(R.id.btFrameL)
        val btnOpenLinearL = findViewById<Button>(R.id.btLinearL)
        val btnOpenRelativeL = findViewById<Button>(R.id.btRelativeL)

        btnOpenFrameL.setOnClickListener {
            val frameActivity = Intent(this, FrameLActivity::class.java)
            register.launch(frameActivity)
        }
        btnOpenLinearL.setOnClickListener {
            val frameActivity = Intent(this, LinearLActivity::class.java)
            register.launch(frameActivity)
        }

    }
}