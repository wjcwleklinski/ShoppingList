package com.wjcwleklinski.shoppinglist.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.wjcwleklinski.shoppinglist.R
import com.wjcwleklinski.shoppinglist.activity.CreateListActivity
import java.lang.ClassCastException
import java.lang.IllegalStateException

class CreateListDialogFragment : DialogFragment() {

    private lateinit var listener: CreateListDialogCallbackListener
    private final var TAG = "CreateDialogFragment"

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_create_list, null)
            val editText = dialogView.findViewById<EditText>(R.id.username)

            builder.setView(inflater.inflate(R.layout.dialog_create_list, null))
                .setPositiveButton("Create",
                DialogInterface.OnClickListener { dialog, id ->
                    listener.onPositive(editText.text.toString())
                })
                .setNegativeButton("Cancel",
                DialogInterface.OnClickListener { dialog, id ->
                    getDialog()?.cancel()
                })
            builder.create()
        } ?: throw IllegalStateException("Activity is null")

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as CreateListDialogCallbackListener
        } catch (ex: ClassCastException) {
            Log.e(TAG, "Activity must implement event interface!")
        }
    }

    interface CreateListDialogCallbackListener {
        fun onPositive(listName: String)
//        fun onNegative(dialog: DialogFragment)
    }

}