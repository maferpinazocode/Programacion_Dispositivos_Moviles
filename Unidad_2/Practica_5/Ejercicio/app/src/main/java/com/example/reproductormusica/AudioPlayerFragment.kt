package com.example.reproductormusica

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class AudioPlayerFragment : Fragment() {

    // Declaracion de Botones, MediaPlayer
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var stopButton: Button
    private lateinit var backButton: Button

    // Método para crear la instancia del fragmento
    companion object {
        private const val ARG_AUDIO_ITEM = "audio_item"

        fun newInstance(audioItem: AudioItem): AudioPlayerFragment {
            val fragment = AudioPlayerFragment()
            val args = Bundle()
            args.putParcelable(ARG_AUDIO_ITEM, audioItem)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.audio_player_fragment, container, false)

        // El fragmento de reproducción recibe el AudioItem a través del argumento
        // Inicializar botones y componentes
        val audioItem = arguments?.getParcelable<AudioItem>(ARG_AUDIO_ITEM)
        val audioImageView: ImageView = view.findViewById(R.id.audioImageView)
        val audioNameTextView: TextView = view.findViewById(R.id.audioNameTextView)
        playButton = view.findViewById(R.id.playButton)
        pauseButton = view.findViewById(R.id.pauseButton)
        stopButton = view.findViewById(R.id.stopButton)
        backButton = view.findViewById(R.id.backButton)

        // Asignar valores a la vista
        audioImageView.setImageResource(audioItem?.imageResId ?: 0)
        audioNameTextView.text = audioItem?.name

        // Inicializar MediaPlayer
        mediaPlayer = MediaPlayer.create(requireContext(), audioItem?.audioResId ?: 0)

        // Lógica para reproducir, pausar y detener el audio
        playButton.setOnClickListener { mediaPlayer.start() }
        pauseButton.setOnClickListener { mediaPlayer.pause() }
        stopButton.setOnClickListener { mediaPlayer.stop(); mediaPlayer.prepare() }

        // Lógica del botón de "volver"
        backButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack() // Volver al fragmento anterior
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
