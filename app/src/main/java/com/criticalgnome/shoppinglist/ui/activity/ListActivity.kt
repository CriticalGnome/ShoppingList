package com.criticalgnome.shoppinglist.ui.activity

import android.os.Bundle
import android.view.View
import com.criticalgnome.shoppinglist.R
import com.criticalgnome.shoppinglist.model.Pool
import com.criticalgnome.shoppinglist.ui.adapter.ListItemAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val items = Pool.items
        items.addAll(Pool.items)
        items.addAll(Pool.items)
        val adapter = ListItemAdapter(items)
        listRecycler.adapter = adapter

        nameEditText.setOnFocusChangeListener { _, hasFocus -> setVisibilityOfAdditionalFields(hasFocus) }
        descriptionEditText.setOnFocusChangeListener { _, hasFocus -> setVisibilityOfAdditionalFields(hasFocus) }
        countEditText.setOnFocusChangeListener { _, hasFocus -> setVisibilityOfAdditionalFields(hasFocus) }
        listRecycler.setOnTouchListener { _, _ ->
            setVisibilityOfAdditionalFields(false)
            return@setOnTouchListener false
        }

    }

    private fun setVisibilityOfAdditionalFields(isVisible: Boolean) {
        if (descriptionLayout.hasFocus() || countLayout.hasFocus()) return
        descriptionLayout.visibility = if (isVisible) View.VISIBLE else View.GONE
        countLayout.visibility = if (isVisible) View.VISIBLE else View.GONE
        if (isVisible) {
            descriptionLayout.bringToFront()
            countLayout.bringToFront()
        } else {

        }
    }
}
