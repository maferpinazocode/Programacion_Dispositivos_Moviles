package com.example.interactionimage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ImageDisplayFragment : Fragment() {

    private var imageIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageIndex = it.getInt(ARG_IMAGE_INDEX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_display, container, false)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val backButton: Button = view.findViewById(R.id.backButton)

        when (imageIndex) {
            0 -> imageView.setImageResource(R.drawable.cocker1)
            1 -> imageView.setImageResource(R.drawable.hushpuppy1)
            2 -> imageView.setImageResource(R.drawable.husky1)
        }

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

    companion object {
        private const val ARG_IMAGE_INDEX = "image_index"

        fun newInstance(imageIndex: Int) = ImageDisplayFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_IMAGE_INDEX, imageIndex)
            }
        }
    }
}
