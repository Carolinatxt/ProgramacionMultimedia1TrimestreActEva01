package com.example.acteva01

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.acteva01.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var ui: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityFormBinding.inflate(layoutInflater)
        setContentView(ui.root)

        // 🔹 El campo de nombre comienza vacío (sin texto predeterminado)
        ui.edNombre.text?.clear()

        // 🔹 Botón ENVIAR → valida campos y muestra confirmación
        ui.btnEnviar.setOnClickListener {
            if (validarFormulario()) {
                val nombre = ui.edNombre.text.toString().trim()

                // Mostrar mensaje de confirmación limpio
                ui.tvConfirmacion.text = "Gracias $nombre, su formulario se ha enviado correctamente."
                ui.tvConfirmacion.visibility = View.VISIBLE

                // Toast de éxito
                Toast.makeText(this, getString(R.string.toast_enviado), Toast.LENGTH_SHORT).show()
            } else {
                // Si hay campos incompletos o inválidos → Toast general
                Toast.makeText(
                    this,
                    getString(R.string.toast_campos_incompletos),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // 🔹 Botón LIMPIAR → borra todos los campos y oculta el mensaje de confirmación
        ui.btnLimpiar.setOnClickListener {
            ui.edNombre.text?.clear()
            ui.edEmail.text?.clear()
            ui.edMensaje.text?.clear()
            ui.tvConfirmacion.visibility = View.GONE
            Toast.makeText(
                this,
                getString(R.string.toast_campos_limpiados),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // 🔹 Función de validación de formulario
    private fun validarFormulario(): Boolean {
        val nombre = ui.edNombre.text.toString().trim()
        val email = ui.edEmail.text.toString().trim()
        val mensaje = ui.edMensaje.text.toString().trim()
        var esValido = true

        // Validar nombre
        if (nombre.isEmpty()) {
            ui.edNombre.error = getString(R.string.error_campo_vacio)
            esValido = false
        }

        // Validar correo electrónico
        if (email.isEmpty()) {
            ui.edEmail.error = getString(R.string.error_campo_vacio)
            esValido = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ui.edEmail.error = getString(R.string.error_email_invalido_formato)
            esValido = false
        }

        // Validar mensaje
        if (mensaje.isEmpty()) {
            ui.edMensaje.error = getString(R.string.error_campo_vacio)
            esValido = false
        }

        return esValido
    }
}
