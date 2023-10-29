package com.example.jetComposePractise

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    val state = mutableStateOf (MyScreenState())
    fun updateText(newText: String) {
        state.value = state.value.copy(text = newText)
    }
    fun updateNamesList (newName: String) {
        val currentList = state.value.nameList
        currentList.add(newName)
        state.value = state.value.copy(nameList = currentList)
    }
}