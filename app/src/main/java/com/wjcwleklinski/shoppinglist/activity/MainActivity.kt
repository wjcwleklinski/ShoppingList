package com.wjcwleklinski.shoppinglist.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import com.wjcwleklinski.shoppinglist.R
import com.wjcwleklinski.shoppinglist.dialog.CreateListDialogFragment

class MainActivity : AppCompatActivity(), CreateListDialogFragment.CreateListDialogCallbackListener {

    private final var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createListEvent(view: View) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val dialogFragment = CreateListDialogFragment()
        dialogFragment.show(fragmentTransaction, TAG)

    }

    fun startShowListActivity(listName: String) {
        val intent = Intent(this, CreateListActivity::class.java)
        startActivity(intent)
    }

    override fun onPositive(listName: String) {
        Log.i(TAG, listName)
    }


}
