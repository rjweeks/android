package com.example.textdemo

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.textdemo.databinding.ActivityMainBinding
import kotlin.math.log

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
            viewModel.addInputText(binding.editText.text.toString())
            itemsAdapter.notifyDataSetChanged()
        }
    }

}