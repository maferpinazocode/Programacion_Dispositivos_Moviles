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
        AudioItem("Every Man Gets His Wish", R.drawable.emghw, "02:30", R.raw.emghw),
        AudioItem("Heavy", R.drawable.the_marias_img, "02:30", R.raw.heavy),
        AudioItem("Paris, Texas", R.drawable.paris_texas, "02:30", R.raw.paris_texas),
        AudioItem("Yes to Heaven", R.drawable.yth_img, "02:30", R.raw.yes_to_heaven),

        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.audio_list_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Al seleccionar un ítem del RecyclerView, se pasa el objeto AudioItem al fragmento de reproducción.
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
