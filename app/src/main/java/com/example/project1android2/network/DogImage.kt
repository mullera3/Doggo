package com.example.project1android2.network

import com.squareup.moshi.Json

data class DogImage( @Json(name = "message") val imgSrcUrl: String)