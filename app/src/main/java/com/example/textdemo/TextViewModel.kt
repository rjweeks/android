package com.example.textdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Date

class TextViewModel : ViewModel() {

    private val liveText : MutableLiveData<List<String>> = MutableLiveData()

    private val inputText = arrayListOf<String>()


    fun addInputText(text : String) {
        val timeStamp: String = SimpleDateFormat("HH:mm").format(Date())
        val entry : String = "[$timeStamp] $text"
        inputText.add(entry)
    }

    fun getInputText(): ArrayList<String> {
        return inputText
    }

    override fun onCleared() {
        super.onCleared()
    }
}