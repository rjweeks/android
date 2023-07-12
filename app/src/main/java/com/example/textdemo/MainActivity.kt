package com.example.textdemo

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.textdemo.databinding.ActivityMainBinding
import java.io.File
import java.io.OutputStreamWriter


class MainActivity : AppCompatActivity() {
    private lateinit var textAdapter: TextAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, com.example.textdemo.R.layout.activity_main)
        val viewModel : TextViewModel =
            ViewModelProvider(this).get(TextViewModel::class.java)
        val recyclerView: RecyclerView = findViewById<View>(com.example.textdemo.R.id.recyclerView) as RecyclerView
//        val itemsAdapter: ArrayAdapter<String> =
//            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, viewModel.getInputText())
        textAdapter = TextAdapter(viewModel.getInputText())
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
        val layoutManager = LinearLayoutManager(applicationContext)
//        binding.recyclerView.adapter = itemsAdapter
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = textAdapter
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.button.setOnClickListener {
            val text = binding.editText.text.toString()
            viewModel.addInputText(text)
            textAdapter.notifyDataSetChanged()
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