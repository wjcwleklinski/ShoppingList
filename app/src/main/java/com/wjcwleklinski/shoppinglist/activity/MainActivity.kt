package com.wjcwleklinski.shoppinglist.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import com.wjcwleklinski.shoppinglist.R

class MainActivity : AppCompatActivity(){

    private final var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "from debug")
    }


    private fun startShowListActivity(listName: String) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("List title", listName)
        }
        startActivity(intent)
    }


    // Create list onClick method
    fun createListEventPrompt(view: View) {
        val layoutInflater = LayoutInflater.from(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_create_list, null)
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(dialogView)

        val userInput = dialogView.findViewById<EditText>(R.id.list_title)

        alertDialogBuilder
            .setCancelable(false)
            .setPositiveButton("Confirm", DialogInterface.OnClickListener { dialog, which ->
                Log.d(TAG, userInput.text.toString())
                startShowListActivity(userInput.text.toString())
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
