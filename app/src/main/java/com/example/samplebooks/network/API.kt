package com.example.samplebooks.network

import com.example.samplebooks.model.SourceData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface API {

    @GET("edition")
    suspend fun getResponse(
        @Query("format") format: String,
    ) : Response<SourceData>
}