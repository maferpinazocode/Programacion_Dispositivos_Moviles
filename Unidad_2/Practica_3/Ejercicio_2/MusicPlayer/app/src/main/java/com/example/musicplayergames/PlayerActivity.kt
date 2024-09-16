package com.example.musicplayergames

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView


class PlayerActivity : AppCompatActivity() {

    private lateinit var tvAudioName: TextView
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button
    private lateinit var btnBack: Button

    // Declaramos el MediaPlayer como una variable de clase
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        // Inicializamos las vistas
        tvAudioName = findViewById(R.id.tvAudioName)
        btnPlay = findViewById(R.id.btnPlay)
        btnPause = findViewById(R.id.btnPause)
        btnStop = findViewById(R.id.btnStop)
        btnBack = findViewById(R.id.btnBack)

        // Recibimos el nombre del audio desde el intent
        val audioName = intent.getStringExtra("audioName")
        val audioResId = intent.getIntExtra("audioResId", 0)

        // Mostrar el nombre del audio seleccionado en el TextView
        tvAudioName.text = audioName

        // Inicializar el MediaPlayer con el archivo de audio desde res/raw
        mediaPlayer = MediaPlayer.create(this, audioResId)

        // Configurar los botones
        btnPlay.setOnClickListener {
            mediaPlayer?.start() // Reproducir el audio
        }

        btnPause.setOnClickListener {
            mediaPlayer?.pause() // Pausar el audio
        }

        btnStop.setOnClickListener {
            mediaPlayer?.stop()  // Detener el audio
            mediaPlayer?.prepare() // Preparar para que pueda reproducirse de nuevo
        }

        btnBack.setOnClickListener {
            // Volver a la actividad anterior
            finish()
        }
    }

    // Liberar los recursos del MediaPlayer cuando la actividad sea destruida
    override fun onDestroy() {
        mediaPlayer?.release() // Libera los recursos del MediaPlayer
        mediaPlayer = null
        super.onDestroy()
    }
}
