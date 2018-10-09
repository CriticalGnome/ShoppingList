package com.criticalgnome.shoppinglist.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.criticalgnome.shoppinglist.R
import com.criticalgnome.shoppinglist.model.Pool
import com.criticalgnome.shoppinglist.ui.adapter.ListItemAdapter
import com.criticalgnome.shoppinglist.ui.fragment.BottomNavigationDrawerFragment
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.toast

class ListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(bottomAppBar)

        val items = Pool.items
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
            R.id.deleteCrossedOut -> toast("Delete crossed out button pressed")
            R.id.undoCrissongOut -> toast("Undo crossing out button pressed")
        }
        return true
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
