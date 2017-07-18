package com.shihochan.kotlindiexample.ui.top

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.shihochan.kotlindiexample.R
import com.shihochan.kotlindiexample.data.GitHubRepository
import com.shihochan.kotlindiexample.databinding.ActivityTopBinding
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

class TopActivity : DaggerAppCompatActivity() {

  @Inject lateinit var gitHubRepository: GitHubRepository

  private lateinit var binding: ActivityTopBinding
  private val adapter = TopAdapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_top)

    val layoutManager = LinearLayoutManager(this)
    layoutManager.isItemPrefetchEnabled = true

    binding.recyclerView.adapter = adapter
    binding.recyclerView.layoutManager = layoutManager
    binding.recyclerView.addItemDecoration(
        HorizontalDividerItemDecoration.Builder(this).build())

    binding.progressBar.visibility = View.VISIBLE
    getFollower()
  }

  fun getFollower() = gitHubRepository.getFollowers("shihochan")
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeBy(
          onNext = {
            binding.progressBar.visibility = View.GONE
            adapter.set(it)
          },
          onError = {
            binding.progressBar.visibility = View.GONE
            Timber.e(it.message)
          })
}
