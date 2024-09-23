package com.example.musicplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AudioSelectionFragment : Fragment() {

    private lateinit var spinner: Spinner
    private lateinit var btnSelect: Button

    private val audioList = listOf(
        "crush by ethel cain",
        "football by ethel cain",
        "heavy by the marias",
        "paris texas by lana del rey",
        "yes to heaven by lana del rey"
    )
    private val audioResIds = listOf(
        R.raw.crush,
        R.raw.football,
        R.raw.heavy,
        R.raw.paris_texas,
        R.raw.yes_to_heaven
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio_selection, container, false)
        spinner = view.findViewById(R.id.spinnerAudios)
        btnSelect = view.findViewById(R.id.btnSelect)

        // Set up the adapter for the spinner
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, audioList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Set up button click listener to navigate to PlayerFragment with selected audio details
        btnSelect.setOnClickListener {
            val selectedAudioIndex = spinner.selectedItemPosition
            val action = AudioSelectionFragmentDirections.actionAudioSelectionFragmentToPlayerFragment(
                audioName = audioList[selectedAudioIndex],
                audioResId = audioResIds[selectedAudioIndex]
            )
            findNavController().navigate(action)
        }

        return view
    }
}
