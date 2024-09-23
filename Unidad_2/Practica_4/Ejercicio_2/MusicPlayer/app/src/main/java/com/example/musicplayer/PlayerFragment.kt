package com.example.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class PlayerFragment : Fragment() {

    // Definir botones, y aspectos
    private lateinit var tvAudioName: TextView
    private lateinit var ivAudioImage: ImageView
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button
    private lateinit var btnBack: Button
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player, container, false)
        tvAudioName = view.findViewById(R.id.tvAudioName)
        ivAudioImage = view.findViewById(R.id.ivAudioImage)
        btnPlay = view.findViewById(R.id.btnPlay)
        btnPause = view.findViewById(R.id.btnPause)
        btnStop = view.findViewById(R.id.btnStop)
        btnBack = view.findViewById(R.id.btnBack)

        // Obtener los argumentos pasados usando Safe Args
        val args = PlayerFragmentArgs.fromBundle(requireArguments())
        val audioName = args.audioName
        val audioResId = args.audioResId
        val imageResId = args.imageResId // Obtener el ID del recurso de la imagen

        // Establecer el nombre del audio en el TextView
        tvAudioName.text = audioName

        // Establecer la imagen correspondiente en el ImageView
        ivAudioImage.setImageResource(imageResId)

        // Inicializar MediaPlayer con el recurso de audio seleccionado
        mediaPlayer = MediaPlayer.create(requireContext(), audioResId)

        // Configurar los botones para reproducir, pausar, detener y regresar
        btnPlay.setOnClickListener { mediaPlayer?.start() }
        btnPause.setOnClickListener { mediaPlayer?.pause() }
        btnStop.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.prepare()
        }
        btnBack.setOnClickListener { findNavController().navigateUp() }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
