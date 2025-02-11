package com.example.androidmodule1.exercise.classroom.ejercicio2edgar

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmodule1.R
import com.example.androidmodule1.exercise.classroom.ejercicio2edgar.recyclerviewelments.ThundercatAdapter
import com.example.androidmodule1.exercise.classroom.ejercicio2edgar.recyclerviewelments.ThundercatEntity

class RecyclerVActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_vactivity)

        val rvThundercat = findViewById<RecyclerView>(R.id.rvThundercat)

        val data = listOf(
            ThundercatEntity("Leono", "Espada del augurio"),
            ThundercatEntity("Linso", "Sabiduria"),
            ThundercatEntity("Pantro", "Tenacidad"),
            ThundercatEntity("Cheetara", "Velocidad"),
            ThundercatEntity("Pumara", "Agilidad"),
            ThundercatEntity("Felino", "Astucia"),
            ThundercatEntity("Felina", "Persistencia"),
            ThundercatEntity("Moonra", "Inmortalidad"),
            ThundercatEntity("Togmog", "Astucia"),
            ThundercatEntity("Reptilio", "Agresividad")
            )
        val adapter = ThundercatAdapter(data)
        rvThundercat.adapter = adapter
        rvThundercat.layoutManager = LinearLayoutManager(this)

    }
}