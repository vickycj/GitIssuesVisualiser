package com.vicky.apps.datapoints.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vicky.apps.datapoints.R
import com.vicky.apps.datapoints.ui.model.Issue
import kotlinx.android.synthetic.main.recycler_child_view.view.*


class DataAdapter constructor(var data: List<Issue>) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_child_view, parent, false)
        return DataViewHolder(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.titleTv.text = data[position].title
        holder.issueIdTv.text = data[position].id.toString()
        holder.createdByTv.text = data[position].user.login
        holder.dateTv.text = data[position].createdAt

    }

    fun updateData(data: List<Issue>) {
        this.data = data
        notifyDataSetChanged()
    }

    class DataViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val titleTv = v.titleTV
        val dateTv = v.dateTV
        val createdByTv = v.createdByTV
        val issueIdTv = v.issueIdTV
    }
}