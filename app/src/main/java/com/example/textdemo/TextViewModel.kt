package com.example.textdemo

import androidx.lifecycle.ViewModel

class TextViewModel : ViewModel() {

    private val inputText = arrayListOf<String>()

    fun addInputText(text : String) {
        inputText.add(text)
    }

    fun getInputText(): ArrayList<String> {
        return inputText
    }

    override fun onCleared() {
        super.onCleared()
        // Dispose All your Subscriptions to avoid memory leaks
    }
}