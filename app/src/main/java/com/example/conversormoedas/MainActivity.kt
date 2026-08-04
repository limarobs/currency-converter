package com.example.conversormoedas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoDolar = findViewById<EditText>(R.id.etDolar)
        val botaoConverter = findViewById<Button>(R.id.btnConverter)
        val textoResultado = findViewById<TextView>(R.id.tvResultado)

        val taxaDolar = 5.50

        botaoConverter.setOnClickListener {

            val textoDigitado = campoDolar.text
                .toString()
                .replace(",", ".")

            val valorDolar = textoDigitado.toDoubleOrNull()

            if (valorDolar == null) {
                campoDolar.error = "Digite um valor válido"
                return@setOnClickListener
            }

            val valorReal = valorDolar * taxaDolar

            val resultadoFormatado = String.format(
                Locale("pt", "BR"),
                "R$ %.2f",
                valorReal
            )

            textoResultado.text = resultadoFormatado
        }
    }
}