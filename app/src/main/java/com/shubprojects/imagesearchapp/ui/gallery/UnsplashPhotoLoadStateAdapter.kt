package com.shubprojects.imagesearchapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shubprojects.imagesearchapp.databinding.UnsplashPhotoLoadStateFooterBinding

class UnsplashPhotoLoadStateAdapter(private val retry : () -> Unit) : LoadStateAdapter<UnsplashPhotoLoadStateAdapter.LoadStateViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewholder {
        val binding = UnsplashPhotoLoadStateFooterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LoadStateViewholder(binding)
    }

    override fun onBindViewHolder(holder: LoadStateViewholder, loadState: LoadState) {
        holder.bind(loadState)
    }

   inner class LoadStateViewholder(
        private val binding : UnsplashPhotoLoadStateFooterBinding
        ): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.buttonRetry.setOnClickListener {
                retry.invoke()
            }
        }


        fun bind(loadState: LoadState){
            binding.apply {
                progressBar.isVisible = loadState is LoadState.Loading
                textViewError.isVisible = loadState !is LoadState.Loading
                buttonRetry.isVisible = loadState !is LoadState.Loading
            }


        }
    }
}