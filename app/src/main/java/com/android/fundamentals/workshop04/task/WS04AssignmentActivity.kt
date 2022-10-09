package com.android.fundamentals.workshop04.task

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.fundamentals.R
import com.android.fundamentals.workshop04.SampleBottomSheet
import com.google.android.material.snackbar.Snackbar
import java.util.*

class WS04AssignmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws04)

        findViewById<Button>(R.id.btn_show_alert_dialog)?.apply {
            setOnClickListener {
                AlertDialog.Builder(this@WS04AssignmentActivity)
                    .setTitle("Alert!")
                    .setPositiveButton("OK") { dialog, which ->
                        Toast.makeText(
                            this@WS04AssignmentActivity,
                            "OK", Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    .setNegativeButton("CANCEL") { _, _ ->
                        Toast.makeText(this@WS04AssignmentActivity,
                        "CANCEL", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .setNeutralButton("RETRY") {_, _ ->
                        Toast.makeText(this@WS04AssignmentActivity,
                        "RETRY", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .setCancelable(true)
                    .setOnCancelListener {Toast.makeText(this@WS04AssignmentActivity,
                            "dialog is cancelled", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .create()
                    .show()
            }
        }

        findViewById<Button>(R.id.btn_show_dialog_fragment)?.apply {
            setOnClickListener {
                WS04AssignmentDialogFragment().show(supportFragmentManager, "TAGGGG")
            }
        }

        findViewById<Button>(R.id.btn_show_time_picker)?.apply {
            setOnClickListener {
                val c = Calendar.getInstance()
                val hour = c.get(Calendar.HOUR_OF_DAY)
                val minute = c.get(Calendar.MINUTE)

                val timePickerDialog = TimePickerDialog(
                    this@WS04AssignmentActivity,
                    { p1, p2, p3 ->
                        Snackbar.make(rootView,
                        "You've chosen $p2:$p3",
                        Snackbar.LENGTH_SHORT)
                            .show()
                    },
                    hour,
                    minute,
                    true
                )
//                    .setButton(TimePickerDialog.BUTTON_POSITIVE, "OK")



                timePickerDialog.show()
            }
        }
        System.currentTimeMillis()

        findViewById<Button>(R.id.btn_show_date_picker)?.apply {
            setOnClickListener {
                val cal = Calendar.getInstance()
                val year = cal.get(Calendar.YEAR)
                val month = cal.get(Calendar.MONTH)
                val dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)
                val datePickerDialog = DatePickerDialog(
                    this@WS04AssignmentActivity,
                    { p0, p1, p2, p3 ->
                        Snackbar.make(
                            rootView,
                            "you choosed $p3/$p2/$p1",
                            Snackbar.LENGTH_LONG
                        )
                            .show()
                    },
                    year,
                    month,
                    dayOfMonth
                )

                datePickerDialog.show()
            }
        }

        findViewById<Button>(R.id.btn_show_bottom_sheet_dialog)?.apply {
            setOnClickListener {
                SampleBottomSheet().show(supportFragmentManager, "TAG2")
                // TODO(WS4:5) show dialog fragment SampleBottomSheet
                //  Look at difference between dialogFragment and BottomSheetFragment layouts drawing  and change dialog_fragment to show buttons under textview
            }
        }
    }
}