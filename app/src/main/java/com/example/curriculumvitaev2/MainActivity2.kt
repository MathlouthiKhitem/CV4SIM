package com.example.curriculumvitaev2

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.lang.UProperty.NAME
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import androidx.appcompat.widget.Toolbar;

class MainActivity2 : AppCompatActivity() {

    private var image : ImageButton? = null
    private  var toolbar : Toolbar? = null
    private var image1 : ImageButton? = null
    private var selectedImage : Uri? = null
    private var uri: Uri? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar)
        val outlinedTextField =findViewById<TextInputEditText>(R.id.outlinedTextField) as TextInputLayout
        val outlinedTextField3 =findViewById<TextInputEditText>(R.id.AgeText) as TextInputLayout
        val outlinedTextField2 =findViewById<TextInputEditText>(R.id.outlinedTextField2) as TextInputLayout


    var Age = outlinedTextField3?.editText?.text!!.toString()

        image = findViewById(R.id.btnGallery)
        image1 = findViewById(R.id.info)
        val  txtName = findViewById(R.id.name) as TextView
        val  txtEmail = findViewById(R.id.Email) as TextView
        val  txtv5 = findViewById(R.id.AgeV) as TextView

        val btnClick = findViewById(R.id.next) as Button

        val galleryImage = registerForActivityResult(
            ActivityResultContracts.GetContent() ,
            ActivityResultCallback { image!!.setImageURI(it) })

        image!!.setOnClickListener{
            galleryImage.launch("image/*")

        }
        image1!!.setOnClickListener(){
            val intent = Intent(this, FourthActivity::class.java).apply {
                putExtra("FULLNAME", outlinedTextField?.editText?.text!!.toString())
                putExtra("EMAIL", outlinedTextField2?.editText?.text!!.toString())
                putExtra("AGE",outlinedTextField3?.editText?.text!!.toString())
               // putExtra("IMAGE", uri.toString())
            }
            startActivity(intent);
        }
        btnClick.setOnClickListener {
            if(galleryImage == null ){
                Toast.makeText(this, "Please select an image !", Toast.LENGTH_SHORT).show()
            }
            if (outlinedTextField?.editText?.text!!.isEmpty())
       {
           txtName?.setText("must not be empty")
           outlinedTextField?.error = "must not be empty"
           txtEmail?.setText("")
           txtv5?.setText("")

       }
       else if (outlinedTextField2?.editText?.text!!.isEmpty())
        {

          txtEmail?.setText("must not be empty")
            outlinedTextField2?.error = "must not be empty"
            txtName?.setText("")
            txtv5?.setText("")
        }
        if (outlinedTextField3?.editText?.text!!.isEmpty())
        {
            txtv5?.setText("must not be empty")
            outlinedTextField3?.error = "must not be empty"
            txtName?.setText("")
            txtEmail?.setText("")

        } else{
            if (outlinedTextField3.editText?.text!!.toString()!=""||outlinedTextField2.editText?.text!!.toString()!="" ||outlinedTextField.editText?.text!!.toString()!=""){
                val intent = Intent(this@MainActivity2, MainActivity3::class.java).apply {
                    putExtra("FULLNAME", outlinedTextField!!.editText?.text.toString())
                    putExtra("EMAIL", outlinedTextField2!!.editText?.text.toString())
                    putExtra("AGE", outlinedTextField3!!.editText?.text.toString())


                }

                startActivity(intent)
            }
            }

        }

            }


    }




