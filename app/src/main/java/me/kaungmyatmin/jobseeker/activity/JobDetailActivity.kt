package me.kaungmyatmin.jobseeker.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
        RestClient.getApiService()
            .getJobDetail(getJobId())
            .enqueue(object :Callback<Job>{
                override fun onResponse(call: Call<Job>, response: Response<Job>) {
                    if(response.isSuccessful){
                        response.body()?.let {

                            popolateUi(it)
                        }
                    }
                }

                override fun onFailure(call: Call<Job>, t: Throwable) {
                    Log.e("network", t.message?:"unknow error")
                }
            })
    }

    private fun popolateUi(job:Job){
        tvDescription.text = HtmlCompat.fromHtml(job.description,HtmlCompat.FROM_HTML_MODE_COMPACT)
        tvLink.setOnClickListener {

            job.url
        }
        tvTitle.text = job.title
        tvCompany.text = job.company
        tvType.text = job.type
        tvLocation.text = job.location
        tvApply.text = job.how_to_apply

    }
}