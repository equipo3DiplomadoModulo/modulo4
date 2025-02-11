package com.example.androidmodule1.exercise.classroom.ejercicio2edgar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R

class Interface1Activity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ }

    // Declaración de objetos
    lateinit var spStates : Spinner
    lateinit var cbPantro : CheckBox
    lateinit var cbLeono : CheckBox
    lateinit var cbSnarf : CheckBox
    lateinit var rgSuscribe : RadioGroup
    lateinit var tvSelected : TextView

    lateinit var charSelected : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface1)

        // inicializaciones
        spStates = findViewById(R.id.spStates)
        cbPantro = findViewById(R.id.cbPantro)
        cbLeono = findViewById(R.id.cbLeono)
        cbSnarf = findViewById(R.id.cbSnarf)
        rgSuscribe = findViewById(R.id.rgSuscribe)
        tvSelected = findViewById(R.id.tvSelected)

        rgSuscribe.setOnCheckedChangeListener{group, checkedId ->
            val name =  getRgLabel(checkedId, false)
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        }

        // ********** SPINNER *************
        val data = arrayListOf("- Elige un estado-", "CDMX", "Edo de México", "Guanajuato", "Veracruz", "Tlaxcaala")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, data).also{
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spStates.adapter = adapter
        spStates.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ){
                val itemSelected =data[position]

                if(position == 0){
                    Toast.makeText(this@Interface1Activity, "No has elegido tu ubicación", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@Interface1Activity, "Elegiste $itemSelected", Toast.LENGTH_SHORT).show()
                }
            }
            override  fun onNothingSelected(parent: AdapterView<*>?){
                TODO("Not yet implemented")
            }

        }
        // ***** CHECKBUTTONS *******
        cbPantro.setOnClickListener(){ isChecked ->
            Toast.makeText(this, "Pantro es tu favorito", Toast.LENGTH_SHORT).show()
        }
        cbLeono.setOnClickListener(){ isChecked ->
            Toast.makeText(this, "Leono es tu favorito", Toast.LENGTH_SHORT).show()
        }
        cbSnarf.setOnClickListener(){ isChecked ->
            Toast.makeText(this, "Snarf es tu favorito", Toast.LENGTH_SHORT).show()
        }

        // ****** IMAGE BUTTON ******
        val ibSelectedCharacter = findViewById<ImageButton>(R.id.ibSendPool)
        ibSelectedCharacter.setOnClickListener {
            tvSelected.text =  "Voto recibido"
        }

        // ******* BOTÓN DE REGRESO *******
        val btnOpenEdgarLayoutsActivity = findViewById<Button>(R.id.btRegresar)
        btnOpenEdgarLayoutsActivity.setOnClickListener {
            val frameActivity = Intent(this, EdgarLayoutsActivity::class.java)
            register.launch(frameActivity)
        }
    }
    // ****** VERIFICANDO RADIOBUTTONS ******
    private fun Interface1Activity.getRgLabel(checkedId: Int, isFromButton : Boolean):String {
        return  when(checkedId){
            R.id.rbYes ->{
                if(isFromButton)"M" else "Aceptado"
            }
            R.id.rbNo ->{
                if(isFromButton)"H" else "En otra ocasión"
            }
            else -> "No se ha decidido"
        }
    }
}