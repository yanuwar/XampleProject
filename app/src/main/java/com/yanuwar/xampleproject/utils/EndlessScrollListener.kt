package com.yanuwar.xampleproject.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

abstract class EndlessScrollListener: RecyclerView.OnScrollListener() {
    private var mPreviousTotal = 0
    private var mLoading = true
    private var currentPage = 0

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = recyclerView!!.childCount
        val totalItemCount = recyclerView.layoutManager.itemCount
        val firstVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        val visibleThreshold = 5

        if (mLoading) {
            if (totalItemCount > mPreviousTotal) {
                mLoading = false
                mPreviousTotal = totalItemCount
                currentPage++
            }
        }
        if (!mLoading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold) {
            onLoadMore(currentPage)
            mLoading = true
        }
    }

    fun resetEndlessScroll() {
        currentPage = 0
        mPreviousTotal = 0
        mLoading = true
    }

    abstract fun onLoadMore(page: Int)
}