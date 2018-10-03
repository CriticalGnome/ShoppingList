package com.criticalgnome.shoppinglist.model

import java.io.Serializable

data class ListItem(
        val name: String,
        val description: String,
        val count: Int,
        val category: ItemCategory?
): Serializable