package com.example.examenunidad_i_global

class Rectangulo {
    private val base: Float = 0.0f
    private val altura: Float = 0.0f

    fun calculoArea() : Float {
        return base * altura
    }

    fun calculoPerimetro() : Float {
        return (base + altura) * 2
    }

}