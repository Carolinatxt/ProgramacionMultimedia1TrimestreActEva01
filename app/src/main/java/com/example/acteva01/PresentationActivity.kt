package com.example.acteva01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.acteva01.databinding.ActivityPresentationBinding

class PresentationActivity : AppCompatActivity() {

    // ViewBinding: permite acceder a las vistas del XML sin usar findViewById
    private lateinit var ui: ActivityPresentationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityPresentationBinding.inflate(layoutInflater)
        setContentView(ui.root)

        // Asignación de valores desde strings.xml (sin hardcodeo)
        ui.tvNombreValor.text = getString(R.string.nombre_valor)
        ui.tvEdadValor.text = getString(R.string.edad_valor)
        ui.tvDescripcionValor.text = getString(R.string.descripcion_texto)

        // Acción del botón → Ir al formulario
        ui.btnIrFormulario.setOnClickListener {
            // Creamos un Intent explícito para abrir FormActivity
            val intent = Intent(this, FormActivity::class.java)

            // Pasamos el nombre como extra (para rellenar el campo de nombre automáticamente)
            intent.putExtra("nombre_prefill", getString(R.string.nombre_valor))

            // Iniciamos la nueva Activity
            startActivity(intent)
        }
    }
}
