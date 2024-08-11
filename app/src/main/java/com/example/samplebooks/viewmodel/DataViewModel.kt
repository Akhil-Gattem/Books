package com.example.samplebooks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplebooks.model.SourceData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.samplebooks.repository.DataRepository

class DataViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val _fetchAudioData = MutableLiveData<SourceData>()
    val fetchAudioData: LiveData<SourceData> get() = _fetchAudioData

    private val _fetchBookData = MutableLiveData<SourceData>()
    val fetchBookData: LiveData<SourceData> get() = _fetchBookData

    init {
        fetch()
    }

    private fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            if (dataRepository.getAudioResponse().isSuccessful) {
                _fetchAudioData.postValue(dataRepository.getAudioResponse().body())
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            if (dataRepository.getAudioResponse().isSuccessful) {
                _fetchBookData.postValue(dataRepository.getTextResponse().body())
            }
        }
    }


}