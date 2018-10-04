package com.criticalgnome.shoppinglist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.criticalgnome.shoppinglist.R
import com.criticalgnome.shoppinglist.model.ListItem
import com.criticalgnome.shoppinglist.model.Pool
import com.criticalgnome.shoppinglist.ui.adapter.ListItemAdapter
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
    }

    companion object {
        const val tag = "List Fragment"
    }
}