package com.shubprojects.imagesearchapp.ui.gallery


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.shubprojects.imagesearchapp.data.UnsplashRepository
import javax.inject.Singleton

@Singleton
class GalleryViewModel @ViewModelInject constructor(
    private val unsplashRepository: UnsplashRepository)
    : ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERRY)

    companion object {
        const val DEFAULT_QUERRY = "cats"
    }


    val photos = currentQuery.switchMap { queryString ->
        unsplashRepository.getSearchResults(queryString).cachedIn(viewModelScope)

    }


    fun searchPhoto(query : String){
        currentQuery.value = query
    }

}
