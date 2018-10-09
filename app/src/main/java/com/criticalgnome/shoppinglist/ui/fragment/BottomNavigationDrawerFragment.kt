package com.criticalgnome.shoppinglist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.criticalgnome.shoppinglist.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import org.jetbrains.anko.toast

class BottomNavigationDrawerFragment: BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bottomsheet, container, false)
        val navigationView = view.findViewById<NavigationView>(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav1 -> context?.toast(getString(R.string.nav1_clicked))
                R.id.nav2 -> context?.toast(getString(R.string.nav2_clicked))
                R.id.nav3 -> context?.toast(getString(R.string.nav3_clicked))
            }
            return@setNavigationItemSelectedListener true
        }
        return view
    }
}