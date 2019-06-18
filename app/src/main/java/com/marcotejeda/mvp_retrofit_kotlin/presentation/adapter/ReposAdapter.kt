package com.marcotejeda.mvp_retrofit_kotlin.presentation.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.marcotejeda.mvp_retrofit_kotlin.R
import com.marcotejeda.mvp_retrofit_kotlin.domain.model.RepoModel

class ReposAdapter(private val activity: Activity, private var items: ArrayList<RepoModel>): BaseAdapter(){

    private var repoModel: RepoModel? = null

    private class ViewHolder(row: View?)  {

        var tvName: TextView? = null

        init {
            this.tvName = row?.findViewById(R.id.tvName)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if(convertView == null) {
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        repoModel = items[position]
        viewHolder.tvName?.text = repoModel?.full_name

        return view as View
    }

    override fun getItem(i: Int): RepoModel {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}