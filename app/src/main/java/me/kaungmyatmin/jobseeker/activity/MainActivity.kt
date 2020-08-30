package me.kaungmyatmin.jobseeker.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import me.kaungmyatmin.jobseeker.JobAdapter
import me.kaungmyatmin.jobseeker.R

class MainActivity : AppCompatActivity() {
    private lateinit var jobAdapter: JobAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jobAdapter = JobAdapter()

        rvJob.apply {
            adapter = jobAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }


    }
    private fun searchJob(q:String?){

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



}