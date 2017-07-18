package com.shihochan.kotlindiexample.ui.top

import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.shihochan.kotlindiexample.data.model.Follower
import com.shihochan.kotlindiexample.databinding.ViewTopContentBinding
import android.view.LayoutInflater
import com.android.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.shihochan.kotlindiexample.R


/**
 * Created by Yuki Shiho on 2017/07/18.
 */

class TopAdapter : RecyclerView.Adapter<TopAdapter.ViewHolder>() {

  val followers = ArrayList<Follower>()

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
      = ViewHolder(ViewTopContentBinding.inflate(LayoutInflater.from(parent?.context), parent, false))

  override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    holder?.bind(followers[position])
  }

  override fun getItemCount(): Int = followers.size

  fun set(followers: List<Follower>) {
    this.followers.addAll(followers)
    notifyItemInserted(followers.size - 1)
  }

  inner class ViewHolder(val binding: ViewTopContentBinding)
    : RecyclerView.ViewHolder(binding.root) {

    private val tabsIntent
      get() = CustomTabsIntent.Builder()
          .setShowTitle(true)
          .setToolbarColor(ContextCompat.getColor(itemView.context, R.color.colorPrimary))
          .build()

    fun bind(follower: Follower) {
      binding.setVariable(BR.follower, follower)
      binding.executePendingBindings()

      Glide.with(itemView.context)
          .load(follower.avatarUrl)
          .placeholder(R.color.colorPrimary)
          .into(binding.avatar)

      itemView.setOnClickListener {
        tabsIntent.launchUrl(itemView.context, Uri.parse(follower.htmlUrl))
      }
    }
  }
}
