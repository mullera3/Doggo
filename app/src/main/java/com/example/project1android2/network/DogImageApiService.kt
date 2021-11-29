package com.example.project1android2.network
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog.ceo/api/breeds/image/"

// Added to print out network requests and responses in Logcat
// Available via the dependency added in build.gradle: com.squareup.okhttp3:logging-interceptor:4.7.2
private val networkLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface DogImageApiService {

    @GET("random")
    suspend fun getRandomDogImage(): DogImage
}

object DogImageApi
{
    val retrofitService: DogImageApiService by lazy { retrofit.create(DogImageApiService::class.java) }
}