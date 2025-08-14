package com.example.examenunidad_i_global

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RectanguloActivity : AppCompatActivity() {

    private lateinit var txtNombre: TextView
    private lateinit var txtAltura: TextView
    private lateinit var txtBase: TextView
    private lateinit var rdbArea: RadioButton
    private lateinit var rdbPerimetro: RadioButton
    private lateinit var txtResultado: TextView
    private lateinit var btnCalcular: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rectangulo)

        iniciarComponentes()
        funcionesBotones()
        verDatos()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun verDatos() {
        val nombre = intent.getStringExtra("nombre") ?: "Sin nombre"
        val base = intent.getFloatExtra("base", 0f)
        val altura = intent.getFloatExtra("altura", 0f)
        txtNombre.text = "Hola, $nombre"
        txtBase.text = "Base: $base"
        txtAltura.text = "Altura: $altura"
    }

    fun iniciarComponentes() {
        txtNombre = findViewById(R.id.txtNombre)
        txtAltura = findViewById(R.id.txtAltura)
        txtBase = findViewById(R.id.txtBase)
        rdbArea = findViewById(R.id.rdbArea)
        rdbPerimetro = findViewById(R.id.rdbPerimetro)
        txtResultado = findViewById(R.id.txtResultado)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnRegresar = findViewById(R.id.btnRegresar)
    }

    fun funcionesBotones() {
        btnCalcular.setOnClickListener {
            val base = intent.getFloatExtra("base", 0f)
            val altura = intent.getFloatExtra("altura", 0f)
            val rectangulo = Rectangulo()
            rectangulo.base = base
            rectangulo.altura = altura

            when {
                rdbArea.isChecked -> {
                    val area = rectangulo.calculoArea()
                    txtResultado.text = "El área es: $area"
                }
                rdbPerimetro.isChecked -> {
                    val perimetro = rectangulo.calculoPerimetro()
                    txtResultado.text = "El perímetro es: $perimetro"
                }
                else -> {
                    Toast.makeText(this, "Selecciona una opción", Toast.LENGTH_SHORT).show()
                }
            }
        }
        btnRegresar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("App Calculo Rectangulo")
            builder.setMessage("¿Desea Volver al Inicio?")

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