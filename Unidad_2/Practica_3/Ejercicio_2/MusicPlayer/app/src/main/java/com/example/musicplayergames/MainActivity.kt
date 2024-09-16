package com.example.musicplayergames

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner


class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var btnSelect: Button

    private val audioList = listOf("audio1", "audio2", "audio3", "audio4", "audio5")
    private val audioResIds = listOf(R.raw.crush, R.raw.football, R.raw.heavy, R.raw.paris_texas, R.raw.yes_to_heaven)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinnerAudios)
        btnSelect = findViewById(R.id.btnSelect)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, audioList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnSelect.setOnClickListener {
            val selectedAudioIndex = spinner.selectedItemPosition
            val intent = Intent(this, PlayerActivity::class.java).apply {
                putExtra("audioName", audioList[selectedAudioIndex])
                putExtra("audioResId", audioResIds[selectedAudioIndex])
            }
            startActivity(intent)
        }
    }
}
