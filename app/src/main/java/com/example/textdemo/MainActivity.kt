package com.example.textdemo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.textdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val enterButton: Button = findViewById(R.id.button)
        //binding.button.setOnClickListener()
        val resultTextView: ListView = findViewById(R.id.listview)
        val inputText: EditText = findViewById(R.id.editText)
        var viewModel : TextViewModel =
            ViewModelProvider(this).get(TextViewModel::class.java)
        val itemsAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, viewModel.getInputText())
        resultTextView.adapter = itemsAdapter
        enterButton.setOnClickListener {
            viewModel.addInputText(inputText.text.toString())
            itemsAdapter.notifyDataSetChanged()
        }
    }
}