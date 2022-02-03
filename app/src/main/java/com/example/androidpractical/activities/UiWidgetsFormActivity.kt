package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.androidpractical.R
import com.example.androidpractical.utils.showCustomToast

class UiWidgetsFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_widgets_form)

        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val etName: EditText = findViewById(R.id.etName)
        val rgGender: RadioGroup = findViewById(R.id.rgGender)
        val cbSports: CheckBox = findViewById(R.id.cbSports)
        val cbGaming: CheckBox = findViewById(R.id.cbGaming)
        val cbProgramming: CheckBox = findViewById(R.id.cbProgramming)

        btnSubmit.setOnClickListener {
            val gender: RadioButton = findViewById(rgGender.checkedRadioButtonId)
            var selectedSports = ""
            var selectedGaming = ""
            var selectedProgramming = ""

            if (cbSports.isChecked) {
                selectedSports = cbSports.text as String
            }
            if (cbGaming.isChecked) {
                selectedGaming = cbGaming.text as String
            }
            if (cbProgramming.isChecked) {
                selectedProgramming = cbProgramming.text as String
            }

            Toast(this).showCustomToast(
                "Form Submitted with Values :-" +
                        "Name : " + etName.text + "\n" +
                        "Gender : " + gender.text + "\n" +
                        "Hobbies : " + selectedSports + " " + selectedGaming + " " + selectedProgramming,
                this
            )
        }
    }
}