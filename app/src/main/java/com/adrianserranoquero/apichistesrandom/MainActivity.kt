package com.adrianserranoquero.apichistesrandom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.adrianserranoquero.apichistesrandom.ui.theme.ApiChistesRandomTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adrianserranoquero.apichistesrandom.ui.ChisteScreen
import com.adrianserranoquero.apichistesrandom.ui.JokeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiChistesRandomTheme {
                val chistesViewModel: JokeViewModel = viewModel()
                ChisteScreen(chistesViewModel)
            }
        }
    }
}
