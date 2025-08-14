package com.example.examenunidad_i_global

import java.io.Serializable

class Rectangulo : Serializable{
    var base: Float = 0.0f
    var altura: Float = 0.0f

    fun calculoArea() : Float {
        return base * altura
    }

    fun calculoPerimetro() : Float {
        return (base + altura) * 2
    }

}