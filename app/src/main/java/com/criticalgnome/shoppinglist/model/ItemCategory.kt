package com.criticalgnome.shoppinglist.model

import androidx.annotation.ColorRes
import java.io.Serializable

data class ItemCategory(
        val id: Long,
        val name: String,
        @ColorRes val color: Int?
): Serializable