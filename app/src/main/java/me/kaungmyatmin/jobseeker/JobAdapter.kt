package me.kaungmyatmin.jobseeker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_job_detail.view.*
import kotlinx.android.synthetic.main.item_job.view.*
import kotlinx.android.synthetic.main.item_job.view.ivCompany
import kotlinx.android.synthetic.main.item_job.view.tvCompany
import kotlinx.android.synthetic.main.item_job.view.tvLocation
import kotlinx.android.synthetic.main.item_job.view.tvTitle
import kotlinx.android.synthetic.main.item_job.view.tvType
import me.kaungmyatmin.jobseeker.model.Job

class JobAdapter(

    private val listener:JobOnClickListener
) : RecyclerView.Adapter<JobAdapter.MyRecyclerView>() {


    private val jobs = mutableListOf<Job>()

    class MyRecyclerView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_job, parent, false)
        return MyRecyclerView(view)
    }

    override fun onBindViewHolder(holder: MyRecyclerView, position: Int) {
        val job = jobs[position]
        holder.itemView.apply {
            setOnClickListener {
                listener.onViewJobDetailClick(job.id)
            }
            Glide.with(context)
                .load(job.company_logo)
                .error(R.drawable.job_search)
                .into(ivCompany)

            tvTitle.text = job.title
            tvCompany.text = job.company
            tvLocation.text = job.location
            tvType.text = job.type
        }

    }

    override fun getItemCount(): Int {
        return jobs.size
    }

    fun setNewData(list: List<Job>) {
        jobs.clear()
        jobs.addAll(list)
        notifyDataSetChanged()
    }
}