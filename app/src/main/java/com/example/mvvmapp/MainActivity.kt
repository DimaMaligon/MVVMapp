package com.example.mvvmapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var vm: ViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("AAA", " Activity created")
        vm = ViewModelProvider(this, MainNewmodelFactory(this)).get(MainViewModel::class.java)

        val saveButton = findViewById<Button>(R.id.buttonSave)
        val loadButton = findViewById<Button>(R.id.buttonLoad)
        val textView = findViewById<TextView>(R.id.textView)

        (vm as MainViewModel).getResultLive().observe(this, Observer {
            textView.text = it.toString()
        })

        saveButton.setOnClickListener {
            val result = (vm as MainViewModel).save("new text")
            textView.text = result.toString()
        }

        loadButton.setOnClickListener {
            val result = (vm as MainViewModel).load()
            textView.text = result.toString()
        }
    }
}