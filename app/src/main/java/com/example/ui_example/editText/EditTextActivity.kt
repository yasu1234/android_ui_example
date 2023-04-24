package com.example.ui_example.editText

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.R
import com.example.ui_example.databinding.ActivityEditTextBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.CompositeDateValidator
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
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
        binding.datePickerEditText.keyListener = null
        binding.datePickerEditText.setOnClickListener {
            showDatePicker()
        }

        binding.materialDatePickerEditText.keyListener = null
        binding.materialDatePickerEditText.setOnClickListener {
            showMaterialDatePicker()
        }

        // detect input text change
        binding.defaultEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
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

    private fun showMaterialDatePicker() {
        MaterialDatePicker.Builder.datePicker().apply {
            // you can set to today
            val dateValidatorMax = DateValidatorPointBackward.before(Date().time)

            // if you set limit of start date, use DateValidatorPointForward
            // val dateValidatorMin = DateValidatorPointForward.from

            // create date limit list
            val validators: List<CalendarConstraints.DateValidator> = listOf(dateValidatorMax)
            val dateValidator: CalendarConstraints.DateValidator = CompositeDateValidator.allOf(validators)
            val constraints: CalendarConstraints = CalendarConstraints.Builder()
                .setValidator(dateValidator)
                .build()
            setCalendarConstraints(constraints)
        }.build().apply {
            addOnPositiveButtonClickListener { datetime ->
                val dateString = SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN).format(datetime)
                binding.materialDatePickerEditText.setText(dateString)
            }
        }.show(supportFragmentManager, "MaterialDatePicker")
    }
}