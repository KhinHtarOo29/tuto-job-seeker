package me.kaungmyatmin.jobseeker.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {
    companion object {
        private var retrofit: Retrofit? = null

        fun getApiService(): ApiService {
            return buildRetrofit().create(ApiService::class.java)
        }
        private fun buildRetrofit(): Retrofit {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl("https://jobs.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
                    .build()
            }
            return retrofit!!
        }

        private fun getClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .callTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
        }
    }
}