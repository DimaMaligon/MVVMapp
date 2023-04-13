package com.example.mvvmapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(userName: String, saveUserCase: String) : ViewModel() {
   private var result = MutableLiveData<String>()

    init {
        Log.d("AAA", " VM created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("AAA", " VM created")
    }

    fun getResultLive(): LiveData<String> {
        return result
    }

    fun save(text: String): String {
        result.value = "save $text"
        return result.value.toString()
    }

    fun load(): String {
        result.value = "load"
        return result.value.toString()
    }

}