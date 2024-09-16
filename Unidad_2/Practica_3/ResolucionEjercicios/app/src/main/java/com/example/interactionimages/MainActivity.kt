package com.example.interactionimages

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Mantén la configuración de WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el Spinner
        val spinner: Spinner = findViewById(R.id.imageSpinner)
        val imageNames = resources.getStringArray(R.array.image_names)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Configurar el botón para ir a la siguiente actividad
        val button: Button = findViewById(R.id.nextButton)
        button.setOnClickListener {
            val selectedImage = spinner.selectedItemPosition
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra("image_index", selectedImage)
            startActivity(intent)
        }
    }
}
