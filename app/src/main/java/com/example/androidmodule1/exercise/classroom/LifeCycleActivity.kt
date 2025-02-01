package com.example.androidmodule1.exercise.classroom

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG)
            .show()


        Log.e("LifeCycle","onCreate")

    }

    override fun onStart() {
        super.onStart()

        Log.e("LifeCycle","onStart")
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG)
            .show()
    }

    override fun onResume() {
        super.onResume()

        Log.e("LifeCycle","onResume")
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG)
            .show()
    }

    override fun onPause() {
        super.onPause()
        Log.e("LifeCycle","onPause")
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG)
            .show()
    }

    override fun onStop() {
        super.onStop()
        Log.e("LifeCycle","onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.e("LifeCycle","onDestroy")
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG)
            .show()
    }

    override fun onRestart() {
        super.onRestart()
    }


}