package me.kaungmyatmin.jobseeker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_job.view.*
import me.kaungmyatmin.jobseeker.model.Job

class JobAdapter(

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