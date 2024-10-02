package com.example.reproductormusica

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Verificar si hay fragmentos ya añadidos (para manejar giros de pantalla)
        if (savedInstanceState == null) {
            // Iniciar el AudioListFragment en el contenedor
            replaceFragment(AudioListFragment())
        }
    }

    // Función auxiliar para reemplazar fragmentos
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
