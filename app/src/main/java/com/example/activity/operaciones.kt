package com.example.activity

import java.io.Serializable

class operaciones:Serializable{

    var listaEstudiantes: ArrayList<Estudiantes> =arrayListOf<Estudiantes>()

    fun registrarEstudiante(estudiante: Estudiantes){

        listaEstudiantes.add(estudiante)
    }

    fun imprimirListaEstudiantes(){
        for(est in listaEstudiantes){
            println(est)
        }
    }

    fun calcularPromedio(est: Estudiantes): Double {

        var prom=(est.nota1 + est.nota2 + est.nota3 + est.nota4 + est.nota5)/5

        return prom
    }
}