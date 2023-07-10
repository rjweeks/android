package com.example.textdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var viewModel : TextViewModel

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val enterButton: Button = findViewById(R.id.button)
        val resultTextView: TextView = findViewById(R.id.textView)
        val inputText: EditText = findViewById(R.id.editText)
        viewModel = ViewModelProvider(this).get(TextViewModel::class.java)
        enterButton.setOnClickListener {
            viewModel.addInputText(inputText.text.toString())
            resultTextView.text = inputText.text
        }
    }
}