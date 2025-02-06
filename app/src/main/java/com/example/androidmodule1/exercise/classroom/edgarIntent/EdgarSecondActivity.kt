package com.example.androidmodule1.exercise.classroom.edgarIntent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R

class EdgarSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edgar_second)

        val tvName = findViewById<TextView>(R.id.tvName)

        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME")) {
                val name = it.getString("EXTRA_NAME")
                tvName.text = name
            }
        }


        val brnReturnInfo = findViewById<Button>(R.id.btnReturnInfo)
        brnReturnInfo.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_IS_CORRECT", false)
            }

            setResult( RESULT_OK,  resultIntent)
            finish()

        }
    }
}