package com.criticalgnome.shoppinglist.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {

    protected fun showFragment(viewContainer: Int, fragment: Fragment) =
            supportFragmentManager
                    .beginTransaction()
                    .add(viewContainer, fragment, fragment.tag)
                    .commit()

}