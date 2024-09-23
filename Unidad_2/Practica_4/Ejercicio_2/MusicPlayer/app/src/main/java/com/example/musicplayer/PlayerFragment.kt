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

        // Obtain arguments passed using Safe Args
        val args = PlayerFragmentArgs.fromBundle(requireArguments())
        val audioName = args.audioName
        val audioResId = args.audioResId

        // Set the audio name to the TextView
        tvAudioName.text = audioName

        // Initialize MediaPlayer with the selected audio resource
        mediaPlayer = MediaPlayer.create(requireContext(), audioResId)

        // Set up buttons for play, pause, stop, and back
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
