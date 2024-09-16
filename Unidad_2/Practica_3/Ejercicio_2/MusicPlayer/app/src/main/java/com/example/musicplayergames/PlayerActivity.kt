package com.example.musicplayergames

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView



class PlayerActivity : AppCompatActivity() {

    // Declaración de vistas
    private lateinit var tvAudioName: TextView
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button
    private lateinit var btnBack: Button
    private lateinit var ivAudioImage: ImageView  // Imagen para mostrar acorde al audio


    private var mediaPlayer: MediaPlayer? = null // Objeto para manejar la reproducción de audio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)  // Establece el diseño de la actividad

        // Inicializa las vistas
        tvAudioName = findViewById(R.id.tvAudioName)
        btnPlay = findViewById(R.id.btnPlay)
        btnPause = findViewById(R.id.btnPause)
        btnStop = findViewById(R.id.btnStop)
        btnBack = findViewById(R.id.btnBack)
        ivAudioImage = findViewById(R.id.ivAudioImage)  // Inicializar el ImageView

        // Obtiene el nombre del audio y el ID del recurso desde el intent
        val audioName = intent.getStringExtra("audioName")
        val audioResId = intent.getIntExtra("audioResId", 0)
        val imageResId = getImageResIdForAudio(audioName)  // Obtener el ID del recurso de imagen

        // Configura el nombre del audio en el TextView y la imagen en el ImageView
        tvAudioName.text = audioName
        mediaPlayer = MediaPlayer.create(this, audioResId)
        ivAudioImage.setImageResource(imageResId)  // Configurar la imagen

        // Configura el comportamiento de los botones
        btnPlay.setOnClickListener {
            mediaPlayer?.start() // Inicia la reproducción del audio
        }

        btnPause.setOnClickListener {
            mediaPlayer?.pause() // Pausa la reproducción del audio
        }

        btnStop.setOnClickListener {
            mediaPlayer?.stop()// Detiene la reproducción del audio
            mediaPlayer?.prepare()  // Prepara el MediaPlayer para una nueva reproducción
        }

        btnBack.setOnClickListener {
            finish()  // Cierra la actividad y vuelve a la anterior (MainActivity)
        }
    }

    // Devuelve el ID del recurso de la imagen correspondiente al nombre del audio
    private fun getImageResIdForAudio(audioName: String?): Int {
        return when (audioName) {
            "crush by ethel cain" -> R.drawable.crush_img
            "football by ethel cain" -> R.drawable.football_img
            "heavy by the marias" -> R.drawable.the_marias_img
            "paris texas by lana del rey" -> R.drawable.paris_texas
            "yes to heaven by lana del rey" -> R.drawable.yth_img
            else -> R.drawable.heavy_img  // Imagen predeterminada
        }
    }

    override fun onDestroy() {
        mediaPlayer?.release() // Libera los recursos del MediaPlayer
        mediaPlayer = null
        super.onDestroy()
    }
}
