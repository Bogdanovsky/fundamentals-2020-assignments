package com.android.fundamentals.workshop04

import android.app.Dialog
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.android.fundamentals.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SampleBottomSheet : BottomSheetDialogFragment() {

    override fun setupDialog(
        dialog: Dialog,
        style: Int
    ) {
        val contentView =
            View.inflate(context, R.layout.dialog_fragment_ws04, null)
        dialog.setContentView(contentView)
        (contentView.parent as View).setBackgroundColor(
            ContextCompat.getColor(
                contentView.context,
                android.R.color.transparent
            )
        )

        contentView.findViewById<Button>(R.id.btn_ok)?.setOnClickListener {
            Toast.makeText(context, "Ok!", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        contentView.findViewById<Button>(R.id.btn_cancel)?.setOnClickListener {
            Toast.makeText(context, "Cancel!", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}