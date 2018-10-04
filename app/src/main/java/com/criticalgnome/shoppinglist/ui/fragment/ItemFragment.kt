package com.criticalgnome.shoppinglist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.criticalgnome.shoppinglist.R
import com.criticalgnome.shoppinglist.model.Pool
import kotlinx.android.synthetic.main.fragment_item.*
import org.jetbrains.anko.backgroundColorResource

class ItemFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_item, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val words = Pool.items

        words.forEach { item ->
            val poolView: View = layoutInflater.inflate(R.layout.item_pool, null, false)
            val poolItemTextView = poolView.findViewById<TextView>(R.id.poolItemTextView)
            poolItemTextView.text = item.name
            item.category?.color?.let { color -> poolItemTextView.backgroundColorResource = color }
            itemsPool.addView(poolView)
        }
    }
}