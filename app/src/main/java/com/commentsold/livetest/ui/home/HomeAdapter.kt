package com.commentsold.livetest.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.commentsold.livetest.databinding.ItemProductBinding
import com.commentsold.livetest.model.ProductItem

class HomeAdapter : ListAdapter<ProductItem, HomeAdapter.ProductItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductItemViewHolder(
        ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class ProductItemViewHolder(
        private val binding: ItemProductBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(productItem: ProductItem) {
            with(binding) {
                waitlistProductDescText.text = productItem.description
                waitlistProductName.text = productItem.product_name
                waitlistProductPrice.text = productItem.image_height.toString()
                itemWaitlistImageView.load(productItem.thumbnail)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProductItem>() {
            override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem) =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}