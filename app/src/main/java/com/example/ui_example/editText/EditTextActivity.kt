package com.example.ui_example.editText

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.R
import kotlinx.android.synthetic.main.activity_edit_text.*
import java.util.*

class EditTextActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_text)

        setupUI()
    }

    private fun setupUI() {
        datePickerEditText.keyListener = null
        datePickerEditText.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val cal = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(this, R.style.DatePickerDialog_Spinner, {_, year, month, dayOfMonth ->
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE))
        datePickerDialog.show()
        datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(this.getColor(R.color.colorAccent))
        datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(this.getColor(R.color.colorAccent))
    }
}