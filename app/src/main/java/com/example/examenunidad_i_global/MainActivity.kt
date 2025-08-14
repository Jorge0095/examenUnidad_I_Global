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
                txtNombre.setText(R.string.txtNombre)
                txtBase.setText(R.string.txtBase)
                txtAltura.setText(R.string.txtAltura)
            }
            btnSiguiente.setOnClickListener {
                val intent = Intent(this, RectanguloActivity::class.java)
                startActivity(intent)
            }
            btnSalir.setOnClickListener {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("App Hola ")
                builder.setMessage("¿Desea Cerrar la Aplicación?")

                builder.setPositiveButton("Si") { dialog, which ->
                    finish()

                }
                builder.setNegativeButton("No") { dialog, which ->
                    Toast.makeText(applicationContext,
                        "Cancelar", Toast.LENGTH_SHORT).show()
                }

                builder.setNeutralButton("Quiza") { dialog, which ->
                    Toast.makeText(applicationContext,
                        "Quiza", Toast.LENGTH_SHORT).show()
                }

                builder.show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}