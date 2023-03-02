package com.example.ui_example.editText

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.R
import com.example.ui_example.databinding.ActivityEditTextBinding
import kotlinx.android.synthetic.main.activity_edit_text.*
import java.util.*

class EditTextActivity: AppCompatActivity() {
    private lateinit var binding: ActivityEditTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
            val timePickerDialog = TimePickerDialog(this, R.style.TimePickerDialog_Spinner, { _, hourOfDay, minutes ->
            },cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true)
            timePickerDialog.show()
            timePickerDialog.getButton(TimePickerDialog.BUTTON_NEGATIVE).setTextColor(this.getColor(R.color.colorAccent))
            timePickerDialog.getButton(TimePickerDialog.BUTTON_POSITIVE).setTextColor(this.getColor(R.color.colorAccent))
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE))
        datePickerDialog.show()
        datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(this.getColor(R.color.colorAccent))
        datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(this.getColor(R.color.colorAccent))
    }
}