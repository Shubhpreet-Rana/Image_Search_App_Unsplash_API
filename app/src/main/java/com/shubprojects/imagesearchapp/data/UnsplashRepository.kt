package com.shubprojects.imagesearchapp.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.shubprojects.imagesearchapp.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {

    fun getSearchResults(query: String)=
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                prefetchDistance = 10,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = {
                UnsplashPagingSource(unsplashApi,query)
            }
        ).liveData
    }