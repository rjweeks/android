package com.example.textdemo

import androidx.lifecycle.LiveData
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
        liveText.value = inputText
    }

    fun getInputText(): ArrayList<String> {
        return inputText
    }

    //variable that will listen to user's input
    var _userInput = MutableLiveData<String>()
    //expose the variable to the owner(activity/fragment)
    val getUserInput: LiveData<String> = _userInput


    override fun onCleared() {
        super.onCleared()
    }
}