package com.criticalgnome.shoppinglist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.criticalgnome.shoppinglist.model.ItemCategory
import com.criticalgnome.shoppinglist.model.ListItem
import com.criticalgnome.shoppinglist.model.Pool
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.toast

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        listTitle.text = "Список покупок 1.09.2018"

        val category1 = Pool.getCategory(1)
        val category2 = Pool.getCategory(2)
        val category3 = Pool.getCategory(3)

        val items = listOf(
                ListItem("Колбаса", "", 0, category1),
                ListItem("Молоко", "", 0, category2),
                ListItem("Сметана", "", 0, category2),
                ListItem("Хлеб", "", 0, category3),
                ListItem("Батон", "", 0, category3),
                ListItem("Колбаса", "", 0, category1),
                ListItem("Молоко", "", 0, category2),
                ListItem("Сметана", "", 0, category2),
                ListItem("Хлеб", "Это описание", 0, category3),
                ListItem("Батон", "", 0, category3),
                ListItem("Колбаса", "", 0, category1),
                ListItem("Молоко", "", 5, category2),
                ListItem("Сметана", "", 0, category2),
                ListItem("Хлеб", "", 0, category3),
                ListItem("Батон", "", 0, category3),
                ListItem("Колбаса", "", 0, category1),
                ListItem("Молоко", "", 0, category2),
                ListItem("Сметана", "", 0, category2),
                ListItem("Хлеб", "", 0, category3),
                ListItem("Батон", "", 2, category3),
                ListItem("Колбаса", "", 0, category1),
                ListItem("Молоко", "", 0, category2),
                ListItem("Сметана", "", 0, category2),
                ListItem("Хлеб", "", 0, category3),
                ListItem("Батон", "", 0, category3)
        )
        val adapter = ListItemAdapter(items)
        listBody.adapter = adapter

        fab.setOnClickListener {
            toast("FAB button pressed")
        }
    }
}
