package com.criticalgnome.shoppinglist.ui.activity

import android.os.Bundle
import com.criticalgnome.shoppinglist.R
import com.criticalgnome.shoppinglist.ui.fragment.ItemFragment
import com.criticalgnome.shoppinglist.ui.fragment.ListFragment
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.toast

class ListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        fab.setOnClickListener {
            toast("FAB button pressed")
        }
        showFragment(R.id.container, ListFragment())

        fab.setOnClickListener {
            showFragment(R.id.container, ItemFragment())
        }
    }
}
