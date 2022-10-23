package com.example.curriculumvitaev2

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.format.DateFormat.is24HourFormat
import android.widget.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.widget.doOnTextChanged
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

private var image1 : ImageButton? = null
private var datee :TextInputEditText?=null
private var Name1 :TextInputEditText?=null
private var datef : TextInputEditText?=null
private var Addres1 :TextInputEditText?=null
private  var toolbar : Toolbar? = null
private var outlinecompanyname : TextInputLayout?= null
private var outlinecompanyaddr : TextInputLayout?= null
private var outlinedatestart : TextInputLayout?= null
var outlinedatefin : TextInputLayout?= null
var counter: Int = 0
private var uri: Uri? = null
lateinit var dataBase: AppDataBase
class Experiencee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experiencee)
        toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar( toolbar)
        datee =findViewById(R.id.dateStardd)
        Name1 =findViewById(R.id.Name1)
        datef=findViewById(R.id.datefinc)
        Addres1 =findViewById(R.id.Address1)
        image1 = findViewById(R.id.imageButton)

         outlinecompanyname = findViewById(R.id.Name)
         outlinedatestart = findViewById<TextInputLayout>(R.id.dateStard)
        outlinedatefin= findViewById<TextInputLayout>(R.id.datefin)
         outlinecompanyaddr = findViewById(R.id.Address)
        val savebtn = findViewById<Button>(R.id.save)
        ///val companyaddr = findViewById<TextView>(R.id.Name)
//        val galleryImage = registerForActivityResult(
//            ActivityResultContracts.GetContent() ,
//            ActivityResultCallback { image1!!.setImageURI(it) })
//
//        image1!!.setOnClickListener{
//            galleryImage.launch("image/*")
//    }







        Name1!!.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                outlinecompanyname!!.editText!!.error = "Must not be empty"
                savebtn.isEnabled = false
            } else {
                outlinecompanyname!!.editText!!.error = null
                savebtn.isEnabled = !(Addres1!!.text!!.isEmpty())
            }
        }
        Addres1!!.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                outlinecompanyaddr!!.editText!!.error = "Must not be empty"
                savebtn.isEnabled = false
            } else {
                outlinecompanyaddr!!.editText!!.error  = null
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
        /**
         * Image View init & on click listener event
         */
        val image = findViewById<ImageView>(R.id.imageButton)
        image.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 3)
        }
    }
    @SuppressLint("ResourceType")
    fun addToDataBase(){
        var champion : ExperienceData? = null

      when(counter){
            0 -> champion = ExperienceData( 1,companyname= outlinecompanyname!!.editText!!.text.toString(),companyimage =image1!!.id,companyaddress=outlinecompanyaddr!!.editText!!.text.toString(),companystartdate=outlinedatestart!!.editText!!.text!!.toString(),companyenddate=outlinedatefin!!.editText!!.text!!.toString())

      }

      counter++
       try {
            //TODO 11 "Add a champion in the database and refresh the recyclerView"

       }catch (ex: Exception){
           Toast.makeText(this, "Could not add the champion !",Toast.LENGTH_SHORT).show()
        }

    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val selectedImage: Uri? = data.data
            val imageView = findViewById<ImageView>(R.id.imageButton)
            imageView.setImageURI(selectedImage)
            uri = selectedImage

        } else {
            Toast.makeText(applicationContext, "You haven't picked Image", Toast.LENGTH_LONG)
                .show();

        }

    }
}




