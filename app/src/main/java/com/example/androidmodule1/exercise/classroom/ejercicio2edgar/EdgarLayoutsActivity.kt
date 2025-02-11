package com.example.androidmodule1.exercise.classroom.ejercicio2edgar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmodule1.R
import com.example.androidmodule1.exercise.classroom.Ejercicio2Activity


class EdgarLayoutsActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edgar_layouts)

        val btnOpenFrameL = findViewById<Button>(R.id.btFrameL)
        val btnOpenLinearL = findViewById<Button>(R.id.btLinearL)
        val btnOpenRelativeL = findViewById<Button>(R.id.btRelativeL)
        val btOpenConstraintLActivity = findViewById<Button>(R.id.btConstraintL)
        val btOpenInterface1Activity = findViewById<Button>(R.id.btInterface1)
        val btOpenRecyclerVActivity = findViewById<Button>(R.id.btInterface2)


        btnOpenFrameL.setOnClickListener {
            val frameActivity = Intent(this, FrameLActivity::class.java)
            register.launch(frameActivity)
        }
        btnOpenLinearL.setOnClickListener {
            val frameActivity = Intent(this, LinearLActivity::class.java)
            register.launch(frameActivity)
        }
        btnOpenRelativeL.setOnClickListener {
            val frameActivity = Intent(this, RelativeLActivity::class.java)
            register.launch(frameActivity)
        }
        btOpenConstraintLActivity.setOnClickListener {
            val frameActivity = Intent(this, ConstraintLActivity::class.java)
            register.launch(frameActivity)
        }
        btOpenInterface1Activity.setOnClickListener {
            val frameActivity = Intent(this, Interface1Activity::class.java)
            register.launch(frameActivity)
        }
        btOpenRecyclerVActivity.setOnClickListener {
            val frameActivity = Intent(this, RecyclerVActivity::class.java)
            register.launch(frameActivity)
        }


        // ******* BOTÓN DE REGRESO *******
        val btnOpenEjercicio2Activity = findViewById<Button>(R.id.btOpenEjercicio2)
        btnOpenEjercicio2Activity.setOnClickListener {
            val frameActivity = Intent(this, Ejercicio2Activity::class.java)
            register.launch(frameActivity)
        }

    }
}