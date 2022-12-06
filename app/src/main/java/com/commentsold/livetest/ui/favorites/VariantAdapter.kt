package com.commentsold.livetest.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.commentsold.livetest.databinding.ItemVariantBinding
import com.commentsold.livetest.model.Variant

class VariantAdapter : ListAdapter<Variant, VariantAdapter.VariantItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VariantItemViewHolder(
        ItemVariantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    inner class VariantItemViewHolder(
        private val binding: ItemVariantBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(variant: Variant) {
            with(binding) {
                variantNameText.text = variant.name
                variantTotalText.text = variant.total.toString()
            }
        }
    }

    override fun onBindViewHolder(holder: VariantItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Variant>() {
            override fun areItemsTheSame(oldItem: Variant, newItem: Variant): Boolean =
                oldItem.name == newItem.name


            override fun areContentsTheSame(oldItem: Variant, newItem: Variant): Boolean =
                oldItem == newItem
        }
    }
}