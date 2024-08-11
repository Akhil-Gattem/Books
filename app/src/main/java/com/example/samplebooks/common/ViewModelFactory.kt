package com.example.samplebooks.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.samplebooks.repository.DataRepository
import com.example.samplebooks.viewmodel.DataViewModel


class ViewModelFactory(private val dataRepository: DataRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(DataViewModel::class.java)) {
            return DataViewModel(dataRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}