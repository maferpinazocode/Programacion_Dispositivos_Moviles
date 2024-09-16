package com.example.interactionimages

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        // Obtener la referencia del ImageView
        val imageView: ImageView = findViewById(R.id.imageView)

        // Obtener el índice de la imagen seleccionada desde el Intent
        val imageIndex = intent.getIntExtra("image_index", 0)

        // Mostrar la imagen correspondiente
        when (imageIndex) {
            0 -> imageView.setImageResource(R.drawable.cocker1)
            1 -> imageView.setImageResource(R.drawable.hushpuppy1)
            2 -> imageView.setImageResource(R.drawable.husky1)
        }

        // Configurar el botón para volver a la actividad anterior
        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish() // Termina la actividad actual y vuelve a la anterior
        }
    }
}
