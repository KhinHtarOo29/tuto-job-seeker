package me.kaungmyatmin.jobseeker.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_job_detail.*
import me.kaungmyatmin.jobseeker.R
import me.kaungmyatmin.jobseeker.model.Job
import me.kaungmyatmin.jobseeker.rest.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JobDetailActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context, jobId: String): Intent {
            return Intent(context, JobDetailActivity::class.java)
                .putExtra("jobId", jobId)
        }
    }

    private fun getJobId() = intent.getStringExtra("jobId") ?: ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

    }
}