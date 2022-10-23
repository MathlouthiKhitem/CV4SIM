package com.example.curriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.doOnTextChanged
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

private var imag1 : ImageButton? = null
private var datee : TextInputEditText?=null
private var Name1 : TextInputEditText?=null
private var datef : TextInputEditText?=null
private var Addres1 : TextInputEditText?=null
private  var toolbar : Toolbar? = null
class Education : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)
        imag1 = findViewById(R.id.imageEDUCATION)
        toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar( toolbar)
        datee =findViewById(R.id.dateStarddu)
        Name1 =findViewById(R.id.NameeU)
        datef=findViewById(R.id.datefinnU)
        Addres1 =findViewById(R.id.AddresU)
        val outlinecompanyname = findViewById<TextInputLayout>(R.id.NameU)
        val outlinedatestart = findViewById<TextInputLayout>(R.id.dateStardU)
        val outlinecompanyaddr = findViewById<TextInputLayout>(R.id.AddressU)
        val savebtn = findViewById<Button>(R.id.SaveU)
        val galleryImage = registerForActivityResult(
            ActivityResultContracts.GetContent() ,
            ActivityResultCallback { imag1!!.setImageURI(it) })

        imag1!!.setOnClickListener{
            galleryImage.launch("image/*")
        }

        Name1!!.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                outlinecompanyname.error = "Must not be empty"
                savebtn.isEnabled = false
            } else {
                outlinecompanyname.error = null
                savebtn.isEnabled = !(Addres1!!.text!!.isEmpty())
            }
        }
        Addres1!!.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                outlinecompanyaddr.error = "Must not be empty"
                savebtn.isEnabled = false
            } else {
                outlinecompanyaddr.error = null
                savebtn.isEnabled = !(Name1!!.text!!.isEmpty())
            }
        }
        datee!!.setOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date")
                .build()
            picker.show(supportFragmentManager, "materialDatePicker")
            picker.addOnPositiveButtonClickListener {
                picker.headerText
                datee!!.setText(picker.headerText)
            }
        }
        datef!!.setOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date")
                .build()
            picker.show(supportFragmentManager, "materialDatePicker")
            picker.addOnPositiveButtonClickListener {
                picker.headerText
                datef!!.setText(picker.headerText)
            }
        }
 

    }
}