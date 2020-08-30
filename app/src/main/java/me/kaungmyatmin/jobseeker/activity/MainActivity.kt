package me.kaungmyatmin.jobseeker.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import me.kaungmyatmin.jobseeker.JobAdapter
import me.kaungmyatmin.jobseeker.JobOnClickListener
import me.kaungmyatmin.jobseeker.R
import me.kaungmyatmin.jobseeker.model.Job
import me.kaungmyatmin.jobseeker.rest.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),JobOnClickListener {
    private lateinit var jobAdapter: JobAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jobAdapter = JobAdapter(this)

        rvJob.apply {
            adapter = jobAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        searchJob("")

    }
    private fun searchJob(q:String?){
        RestClient.getApiService()
            .searchJobs(q?:"")
            .enqueue(object :Callback<List<Job>>{


                override fun onResponse(call: Call<List<Job>>, response: Response<List<Job>>) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            jobAdapter.setNewData(it)
                        }
                    }
                }
                override fun onFailure(call: Call<List<Job>>, t: Throwable) {

                }
            })

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        val menuItem=menu?.findItem(R.id.search)
        val actionView = menuItem?.actionView as SearchView?
        actionView?.let {
            it.queryHint = "Search.."
            it.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    searchJob(query)
                    menuItem?.collapseActionView()
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }
            } )
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onViewJobDetailClick(id: String) {
        val intent =JobDetailActivity.newIntent(this,id)
        startActivity(intent)
    }

}