package com.example.interactionimage

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a Spinner y Button
        imageSpinner = findViewById(R.id.imageSpinner)
        nextButton = findViewById(R.id.nextButton)

        // Crear un array de nombres de las imágenes
        val imageNames = arrayOf("Cocker Spaniel", "Basset Hound", "Husky")

        // Crear un adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        imageSpinner.adapter = adapter

        // Listener del botón para ir a la siguiente actividad
        nextButton.setOnClickListener {
            // Obtener el índice seleccionado en el Spinner
            val selectedImageIndex = imageSpinner.selectedItemPosition

            // Crear un Intent para cambiar de actividad
            val intent = Intent(this, ImageActivity::class.java)

            // Pasar el índice de la imagen seleccionada a la siguiente actividad
            intent.putExtra("image_index", selectedImageIndex)

            // Iniciar la siguiente actividad
            startActivity(intent)
        }
    }
}