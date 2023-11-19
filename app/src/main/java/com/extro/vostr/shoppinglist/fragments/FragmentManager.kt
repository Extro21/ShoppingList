package com.extro.vostr.shoppinglist.fragments

import androidx.appcompat.app.AppCompatActivity
import com.extro.vostr.shoppinglist.R

object FragmentManager {
    private var currentFrag: BaseFragment? = null

    fun setFragment(newFrag: BaseFragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newFrag)
        transaction.commit()
        currentFrag = newFrag
    }
}