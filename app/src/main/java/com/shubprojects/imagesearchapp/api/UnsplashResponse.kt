package com.shubprojects.imagesearchapp.api

import com.shubprojects.imagesearchapp.data.UnsplashPhoto

data class UnsplashResponse(
    val results : List<UnsplashPhoto>
)