package com.commentsold.livetest.model

data class ProductItem(
    val created_at: Int,
    val description: String,
    val filename: String,
    val image_height: Int,
    val image_width: Int,
    val inventory: List<Inventory>,
    val live_id: Any,
    val post_id: Int,
    val product_id: Int,
    val product_name: String,
    val quantity: Int,
    val style: String,
    val thumbnail: String,
    val isSelected: Boolean = false
) {
    fun getColorVariants(): List<Variant> {
        val returnList: MutableList<Variant> = mutableListOf()

        //  TODO: Add logic here, Use inventory

        return returnList
    }

    fun getSizeVariants(): List<Variant> {
        val returnList: MutableList<Variant> = mutableListOf()

        //  TODO: Add logic here, Use inventory

        return returnList
    }
}