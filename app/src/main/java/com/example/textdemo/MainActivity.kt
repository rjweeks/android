package com.example.textdemo

import android.app.Activity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.AbsListView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.textdemo.databinding.ActivityMainBinding
import java.io.File
import java.io.OutputStreamWriter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel : TextViewModel =
            ViewModelProvider(this).get(TextViewModel::class.java)
        val itemsAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, viewModel.getInputText())
        binding.listview.adapter = itemsAdapter
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.button.setOnClickListener {
            val text = binding.editText.text.toString()
            viewModel.addInputText(text)
            itemsAdapter.notifyDataSetChanged()
            writeFile(text)
        }

    }



    private fun writeFile(text : String) {
        try {
            val path = Environment.getExternalStorageDirectory().toString()
            val root = File(path)
            val textFile = File(root, "entries.txt")
            val writer = OutputStreamWriter(openFileOutput(textFile.name, MODE_APPEND))
            writer.append(text)
            writer.flush()
            writer.close()
        } catch (e : Exception) {
            Log.e("MainActivity",e.message.toString())
        }
    }

}