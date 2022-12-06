package com.commentsold.livetest.ui.favorites

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.commentsold.livetest.databinding.ItemProductSimpleBinding
import com.commentsold.livetest.model.ProductItem

class FavoritesAdapter(
    private val onItemClicked: ((ProductItem) -> Unit)
) : ListAdapter<ProductItem, FavoritesAdapter.ProductItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductItemViewHolder(
        ItemProductSimpleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class ProductItemViewHolder(
        private val binding: ItemProductSimpleBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(productItem: ProductItem) {
            with(binding) {
                itemSimpleImageView.load(productItem.thumbnail)
                itemSimpleNameText.text = productItem.product_name
                root.setBackgroundColor(if (productItem.isSelected) Color.RED else Color.WHITE)
                root.setOnClickListener { onItemClicked(productItem) }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProductItem>() {
            override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem) =
                oldItem.product_id == newItem.product_id

            override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem) =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}