package com.example.samplebooks.repository

import com.example.samplebooks.network.RetrofitInstance

class DataRepository {

    suspend fun getAudioResponse() = RetrofitInstance.api.getResponse(format = "audio")

    suspend fun getTextResponse() = RetrofitInstance.api.getResponse(format = "text")
}
