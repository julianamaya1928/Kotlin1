package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class registrar : AppCompatActivity() {

    var campoDocumento: EditText?=null
    var campoNombre:EditText?=null
    var campoEdad:EditText?=null
    var campoTelefono:EditText?=null
    var campoDireccion:EditText?=null

    var campoMateria1:EditText?=null
    var campoMateria2:EditText?=null
    var campoMateria3:EditText?=null
    var campoMateria4:EditText?=null
    var campoMateria5:EditText?=null
    var campoNota1:EditText?=null
    var campoNota2:EditText?=null
    var campoNota3:EditText?=null
    var campoNota4:EditText?=null
    var campoNota5:EditText?=null

    var operaciones:operaciones?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        var bundle: Bundle? =this.intent.extras
        operaciones= bundle?.getSerializable("operaciones") as operaciones?

        campoDocumento=findViewById(R.id.documento)
        campoNombre=findViewById(R.id.Nombre)
        campoEdad=findViewById(R.id.age)
        campoTelefono=findViewById(R.id.telefhone)
        campoDireccion=findViewById(R.id.direction)

        campoMateria1=findViewById(R.id.materia1)
        campoMateria2=findViewById(R.id.materia2)
        campoMateria3=findViewById(R.id.materia3)
        campoMateria4=findViewById(R.id.materia4)
        campoMateria5=findViewById(R.id.materia5)

        campoNota1=findViewById(R.id.nota1)
        campoNota2=findViewById(R.id.nota2)
        campoNota3=findViewById(R.id.nota3)
        campoNota4=findViewById(R.id.nota4)
        campoNota5=findViewById(R.id.nota5)

        var btnRegistro: Button =findViewById(R.id.BtnRegistrar)
        btnRegistro.setOnClickListener { registrarEstudiante() }
    }

    private fun registrarEstudiante() {
        var est:Estudiantes= Estudiantes()
        est.documento= campoDocumento?.text.toString()
        est.nombre=campoNombre?.text.toString()
        est.edad=campoEdad?.text.toString().toInt()
        est.direccion=campoDireccion?.text.toString()
        est.telefono=campoTelefono?.text.toString()

        est.materia1=campoMateria1?.text.toString()
        est.materia2=campoMateria2?.text.toString()
        est.materia3=campoMateria3?.text.toString()
        est.materia4=campoMateria4?.text.toString()
        est.materia5=campoMateria5?.text.toString()

        est.nota1= campoNota1?.text.toString().toDouble()
        est.nota2= campoNota2?.text.toString().toDouble()
        est.nota3= campoNota3?.text.toString().toDouble()
        est.nota4= campoNota4?.text.toString().toDouble()
        est.nota5= campoNota5?.text.toString().toDouble()

        est.promedio= operaciones!!.calcularPromedio(est)

        operaciones?.registrarEstudiante(est)

        operaciones?.imprimirListaEstudiantes()
    }

    private fun devolverResultados(){
        var miIntent: Intent = Intent()
        miIntent.putExtra("resultado","Registro exitoso")
        var miBundle:Bundle= Bundle()
        miBundle.putSerializable("objetoOperaciones",operaciones)
        miIntent.putExtras(miBundle)
        //miIntent.putExtra("obj",operaciones)
        setResult(RESULT_OK,miIntent)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "Se cierra el registro Activity", Toast.LENGTH_SHORT).show()
            devolverResultados()
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}