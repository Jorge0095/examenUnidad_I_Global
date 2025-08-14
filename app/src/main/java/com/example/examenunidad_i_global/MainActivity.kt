package com.example.examenunidad_i_global

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombre: EditText
    private lateinit var txtBase: EditText
    private lateinit var txtAltura: EditText
    private lateinit var btnLimpiar: Button
    private lateinit var btnSiguiente: Button
    private lateinit var btnSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        iniciarComponentes()
        funcionesBotones()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun iniciarComponentes() {
        // Recuadros
        txtNombre = findViewById(R.id.txtNombre)
        txtBase = findViewById(R.id.txtBase)
        txtAltura = findViewById(R.id.txtAltura)
        // Botones
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnSiguiente = findViewById(R.id.btnSiguiente)
        btnSalir = findViewById(R.id.btnSalir)

    }

    fun funcionesBotones() {
        btnLimpiar.setOnClickListener {
            txtNombre.setText("")
            txtBase.setText("")
            txtAltura.setText("")
        }
        btnSiguiente.setOnClickListener {
            val nombre = txtNombre.text.toString()
            val baseStr = txtBase.text.toString()
            val alturaStr = txtAltura.text.toString()

            if (nombre.isEmpty() || baseStr.isEmpty() || alturaStr.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val base = baseStr.toFloat()
                val altura = alturaStr.toFloat()

                if (base <= 0 || altura <= 0) {
                    Toast.makeText(this, "Los valores deben ser mayores a 0", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val intent = Intent(this, RectanguloActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("base", base)
                intent.putExtra("altura", altura)
                startActivity(intent)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa números válidos", Toast.LENGTH_SHORT).show()
            }
        }
        btnSalir.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("App Rectangulo")
            builder.setMessage("¿Desea Cerrar la Aplicación?")

            builder.setPositiveButton("Si") { dialog, which ->
                finish()

            }
            builder.setNegativeButton("No") { dialog, which ->
                Toast.makeText(applicationContext,
                    "Cancelar", Toast.LENGTH_SHORT).show()
            }

            builder.show()
        }
    }
}