package com.example.mvvmapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainNewmodelFactory(mainActivity: MainActivity) : ViewModelProvider.Factory {

    private fun userRepository() {
        Log.d("AAA", " VM repo")
    }

    private fun getUserName(): String{
        Log.d("AAA", " VM getUser")
        return "username"
    }

    private fun saveUserCase() : String{
        Log.d("AAA", " VM saveUserCase")
        return "saveUserName"
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserName(), saveUserCase()) as T
    }
}