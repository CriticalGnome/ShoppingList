package com.criticalgnome.shoppinglist.model

import com.criticalgnome.shoppinglist.R

object Pool {

    val categories = mutableListOf(
            ItemCategory(1, "Мясо", R.color.white),
            ItemCategory(2, "Молоко", R.color.white),
            ItemCategory(3, "Выпечка", R.color.extraLightGray)
    )

    val items = mutableListOf(
            ListItem("Свинина", "", 0, getCategory(1)),
            ListItem("Говядина", "", 0, getCategory(1)),
            ListItem("Колбаса", "", 0, getCategory(1)),
            ListItem("Молоко", "", 0, getCategory(2)),
            ListItem("Масло", "", 0, getCategory(2)),
            ListItem("Сметана", "", 0, getCategory(2)),
            ListItem("Кефир", "", 0, getCategory(2)),
            ListItem("Хлеб", "", 0, getCategory(3)),
            ListItem("Батон", "", 0, getCategory(3)),
            ListItem("Ватрушка", "", 0, getCategory(3))
    )

    fun addItem(item: ListItem) = items.add(item)
    fun getItems(name: String) = items.filter { it.name.contains(name) }

    fun addCategory(category: ItemCategory) = categories.add(category)
    fun getCategory(id: Long) = categories.find { it.id == id }
    fun getCategories(name: String) = categories.filter { it.name.contains(name) }

}
