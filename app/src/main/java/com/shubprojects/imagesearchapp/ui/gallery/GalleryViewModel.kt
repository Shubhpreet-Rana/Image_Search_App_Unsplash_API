package com.shubprojects.imagesearchapp.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.shubprojects.imagesearchapp.data.UnsplashRepository
import javax.inject.Singleton

@Singleton
class GalleryViewModel @ViewModelInject constructor(
    private val unsplashRepository: UnsplashRepository)
    : ViewModel() {
}