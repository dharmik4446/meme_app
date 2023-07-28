package com.example.herroinforetrofit

import retrofit2.Call
import retrofit2.http.GET

interface APIinterface {
        @GET("gimme")
        fun getData(): Call<responedaclass>
}