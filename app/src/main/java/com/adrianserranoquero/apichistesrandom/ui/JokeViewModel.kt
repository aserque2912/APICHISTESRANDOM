package com.adrianserranoquero.apichistesrandom.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.adrianserranoquero.apichistesrandom.data.JokeRepository

class JokeViewModel(
    private val repository: JokeRepository = JokeRepository()
) : ViewModel() {

    private val _chiste = MutableStateFlow<String?>(null)
    val chiste: StateFlow<String?> = _chiste

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun obtenerChiste() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Llama al repositorio para obtener un chiste
                val nuevoChiste = repository.getJoke()
                _chiste.value = nuevoChiste
            } catch (e: Exception) {
                _chiste.value = "Error al cargar el chiste."
            } finally {
                _isLoading.value = false
            }
        }
    }
}
