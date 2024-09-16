package com.example.musicplayergames

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView



class PlayerActivity : AppCompatActivity() {

    private lateinit var tvAudioName: TextView
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button
    private lateinit var btnBack: Button
    private lateinit var ivAudioImage: ImageView  // Añadir este ImageView

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        tvAudioName = findViewById(R.id.tvAudioName)
        btnPlay = findViewById(R.id.btnPlay)
        btnPause = findViewById(R.id.btnPause)
        btnStop = findViewById(R.id.btnStop)
        btnBack = findViewById(R.id.btnBack)
        ivAudioImage = findViewById(R.id.ivAudioImage)  // Inicializar el ImageView

        val audioName = intent.getStringExtra("audioName")
        val audioResId = intent.getIntExtra("audioResId", 0)
        val imageResId = getImageResIdForAudio(audioName)  // Obtener el ID del recurso de imagen

        tvAudioName.text = audioName
        mediaPlayer = MediaPlayer.create(this, audioResId)
        ivAudioImage.setImageResource(imageResId)  // Configurar la imagen

        btnPlay.setOnClickListener {
            mediaPlayer?.start()
        }

        btnPause.setOnClickListener {
            mediaPlayer?.pause()
        }

        btnStop.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.prepare()
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

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
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }
}
