package me.kaungmyatmin.jobseeker.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

}