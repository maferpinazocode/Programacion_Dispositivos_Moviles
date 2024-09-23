package com.example.interactionimage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ImageSelectionFragment : Fragment() {

    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_selection, container, false)

        imageSpinner = view.findViewById(R.id.imageSpinner)
        nextButton = view.findViewById(R.id.nextButton)

        val imageNames = arrayOf("Cocker Spaniel", "Basset Hound", "Husky")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, imageNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        imageSpinner.adapter = adapter

        nextButton.setOnClickListener {
            val selectedImageIndex = imageSpinner.selectedItemPosition
            val action = ImageSelectionFragmentDirections.action_imageSelectionFragment_to_imageDisplayFragment(selectedImageIndex)
            findNavController().navigate(action)
        }

        return view
    }
}
