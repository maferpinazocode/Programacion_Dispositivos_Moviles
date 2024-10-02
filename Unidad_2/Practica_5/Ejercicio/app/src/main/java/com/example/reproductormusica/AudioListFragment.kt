package com.example.reproductormusica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AudioListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var audioAdapter: AudioAdapter
    private val audioList = listOf(
        AudioItem("Crush", R.drawable.crush_img, "03:45", R.raw.crush),
        AudioItem("Football", R.drawable.football_img, "02:30", R.raw.football),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.audio_list_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        audioAdapter = AudioAdapter(audioList) { audioItem ->
            val fragment = AudioPlayerFragment.newInstance(audioItem)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = audioAdapter
        return view
    }
}
