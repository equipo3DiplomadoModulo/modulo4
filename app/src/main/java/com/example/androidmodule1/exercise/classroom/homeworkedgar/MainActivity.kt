package com.example.androidmodule1.exercise.classroom.homeworkedgar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmodule1.R
import com.example.androidmodule1.exercise.classroom.Ejercicio2Activity

class MainActivity : AppCompatActivity() {


    var verificado:Boolean= false

    /*INTERFACE OBJECTS*/
    lateinit var etName : EditText
    lateinit var etSecondName : EditText
    lateinit var etEmail : EditText
    lateinit var rgSex : RadioGroup
    lateinit var etPass : EditText
    lateinit var etPassConfirm : EditText

    lateinit var tvMessages : TextView
    lateinit var btSend : Button
    var sex = "H"
    var added = ""



   override fun onCreate(savedInstanceState: Bundle?) {
       val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ }
       super.onCreate(savedInstanceState)
       enableEdgeToEdge()
       setContentView(R.layout.activity_main)
       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
           val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
           v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
           insets
       }

       etName = findViewById(R.id.etName)
       etSecondName = findViewById(R.id.etSecondName)
       etEmail = findViewById(R.id.etEmail)
       rgSex = findViewById(R.id.rgSex)
       etPass = findViewById(R.id.etPass)
       etPassConfirm = findViewById(R.id.etPassConfirm)


       tvMessages = findViewById(R.id.tvMessages)
       btSend = findViewById(R.id.btSend)

       tvMessages.visibility = View.GONE


      btSend.setOnClickListener{

           added = "Te falta ingresar "
           if(verificado == false){ tvMessages.visibility = View.VISIBLE}

           val selectedRgGrOption = getRgLabel(rgSex.checkedRadioButtonId, true)

           if(etName.getText().toString().isEmpty()){
               added += "tu nombre"
               verificado = false;
           }else{
               tvMessages.text = ""
               verificado = true;
           }

           if(etSecondName.getText().toString().isEmpty()){
               added += ", tus apellidos"
               verificado = false;
           }else{
               tvMessages.text = ""
               verificado = true;
           }

           if(etEmail.getText().toString().isEmpty()){
               added +=  ", tu correo electrónico"
               verificado = false;
           }else{
               tvMessages.text = ""
               verificado = true;
           }

           if (selectedRgGrOption == ""){
               added += ", tu sexo"
               verificado = false;
           }else{
               sex = selectedRgGrOption
               tvMessages.text = ""
               verificado = true;
           }

           if(etPass.getText().toString().isEmpty()){
               added += ", tu contraseña"
               verificado = false;
           }else{
               tvMessages.text = ""
               verificado = true;
           }
           if(  etPassConfirm.getText().toString().isEmpty() || etPass.getText().toString().isEmpty()
               || selectedRgGrOption == "" || etEmail.getText().toString().isEmpty()
                || etSecondName.getText().toString().isEmpty() || etName.getText().toString().isEmpty()
               ){
              // if(){ Toast.makeText(this, "VERDADERO PASA", Toast.LENGTH_SHORT).show()} else{}
               if(  etPassConfirm.getText().toString().isEmpty()){ added += ", tu confirmación de contraseña"}
               verificado = false;
           }else{
               tvMessages.visibility = View.GONE
               verificado = true;
           }
          tvMessages.text = added
           if(verificado){
               //Toast.makeText(this, "Registro valido", Toast.LENGTH_SHORT).show()

               val frameActivity = Intent(this, RegistredActivity::class.java).apply{

                   putExtra("EXTRA_NAME", etName.text.toString())
                   putExtra("EXTRA_SECONDNAME", etSecondName.text.toString())
                   putExtra("EXTRA_EMAIL", etEmail.text.toString())
                   putExtra("EXTRA_SEX", sex)

               }
               register.launch(frameActivity)
           }

       }
  }

    private fun MainActivity.getRgLabel(checkedId: Int, isFromButton : Boolean):String {
        return  when(checkedId){
            R.id.rbWomen ->{
                if(isFromButton)"M" else "Mujer"

            }
            R.id.rbMen ->{
                if(isFromButton)"H" else "Hombre"
            }
            else -> ""
        }
    }

}