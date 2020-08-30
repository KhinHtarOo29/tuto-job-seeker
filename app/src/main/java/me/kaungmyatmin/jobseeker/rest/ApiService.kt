package me.kaungmyatmin.jobseeker.rest

import me.kaungmyatmin.jobseeker.model.Job
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("positions.json")
    fun searchJobs(@Query("search") query: String):Call<List<Job>>

    @GET("positions/{jobId}.json")
    fun getJobDetail(@Path("jobId") id:String): Call<Job>

}