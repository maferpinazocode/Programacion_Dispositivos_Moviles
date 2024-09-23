package com.example.musicplayer

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    // Declaración de vistas
    private lateinit var spinner: Spinner
    private lateinit var btnSelect: Button

    // Lista de audios disponibles y sus recursos asociados
    private val audioList = listOf(
        "crush by ethel cain",
        "football by ethel cain",
        "heavy by the marias",
        "paris texas by lana del rey",
        "yes to heaven by lana del rey"
    )

    // IDs de los recursos de audio en res/raw
    private val audioResIds = listOf(
        R.raw.crush,
        R.raw.football,
        R.raw.heavy,
        R.raw.paris_texas,
        R.raw.yes_to_heaven
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Establece el diseño de la actividad

        // Inicializa las vistas
        spinner = findViewById(R.id.spinnerAudios)
        btnSelect = findViewById(R.id.btnSelect)

        // Configura el adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, audioList).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = adapter

        // Configura el comportamiento del botón "Seleccionar"
        btnSelect.setOnClickListener {
            // Obtiene el índice del audio seleccionado en el Spinner
            val selectedAudioIndex = spinner.selectedItemPosition

            // Crea un Intent para iniciar PlayerActivity
            val intent = Intent(this, PlayerActivity::class.java).apply {
                putExtra("audioName", audioList[selectedAudioIndex])  // Envía el nombre del audio
                putExtra("audioResId", audioResIds[selectedAudioIndex])  // Envía el ID del recurso de audio
            }

            // Inicia la actividad PlayerActivity
            startActivity(intent)
        }
    }
}
