package com.example.curriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.NameValueTable.NAME
import android.widget.*
import androidx.appcompat.widget.Toolbar;

class MainActivity3 : AppCompatActivity()  {
    private var checkBoxA : CheckBox? = null
    private var checkBoxF : CheckBox? = null
    private var checkBoxE : CheckBox? = null
    private var checkBoxM : CheckBox? = null
    private var checkBoxS : CheckBox? = null
    private var checkBoG : CheckBox? = null
    private var image1: ImageButton? = null
    private var image: ImageButton? = null
    private var age: String? = ""
    private var ios :SeekBar?=null
    private var Flutter :SeekBar?=null
    private var Android :SeekBar?=null
    private var toolbar: Toolbar? = null
    private var btnSubmit : Button? = null
    private var btnHobbies : Button? = null
    private var langage = ""
    private var hobbies = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        checkBoxA = findViewById(R.id.Arabic)
        checkBoxF =  findViewById(R.id.French)
        checkBoxE =  findViewById(R.id.English)
        checkBoxM = findViewById(R.id.Music)
        checkBoxS =  findViewById(R.id.Sport)
        checkBoG =  findViewById(R.id.Games)
        btnSubmit = findViewById(R.id.Submit)
        btnHobbies = findViewById(R.id.hobbies)
        image1 = findViewById(R.id.info)
        image = findViewById(R.id.info)
        ios=findViewById(R.id.seekI)
        Flutter=findViewById(R.id.seekF)
        Android=findViewById(R.id.seekA)
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar)
        image1!!.setOnClickListener() {
            val intent = Intent(this, FourthActivity::class.java).apply {

                putExtra("MUSIC", checkBoxM!!.isChecked)
                putExtra("SPORTS",checkBoxS!!.isChecked)
                putExtra("GAMES", checkBoG!!.isChecked)
                putExtra("FLUTTER", Flutter?.progress)
                putExtra("ANDROID", Android?.progress)
                putExtra("IOS", ios?.progress)


            }
            startActivity(intent)


        }
        image!!.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java).apply {
//                putExtra("FULLNAME", txtFullName?.editText?.text!!.toString())
                //       putExtra("EMAIL", txtEmail?.editText?.text!!.toString())

            }
            startActivity(intent)


        }
        if (checkBoxA?.isChecked == true) {
            langage == "arabic "
        }
        if (checkBoxF?.isChecked == true) {
            langage == "frensh "
        }
        if (checkBoxE?.isChecked == true) {
            langage == "english "
        }
        if (checkBoxS?.isChecked == true) {
            hobbies == "sport "
        }
        if (checkBoG?.isChecked == true) {
            hobbies == "games"
        }
        if (checkBoxM?.isChecked == true) {
            hobbies == "music "
        }

        val name = intent.getStringExtra("FULLNAME").toString()
       val EMAIL = intent.getStringExtra("EMAIL").toString()
//        val f=intent.getStringExtra("music");
//        val s=intent.getStringExtra("sport");
//        val g=intent.getStringExtra("Games");
//val fragment2 =BlankFragment2()
//        btnHobbies!!.setOnClickListener{
//            val  bundle =Bundle();
//            bundle.putString("music",f)
//            bundle.putString("sport",s)
//            bundle.putString("Games",g)
//            fragment2.arguments=bundle
//            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragment2).commit()
//        }


        fun checkAnswer(): Boolean{

            if(checkBoxA!!.isChecked || checkBoxF!!.isChecked||checkBoxE!!.isChecked||checkBoxM!!.isChecked ||checkBoxS!!.isChecked ||checkBoG!!.isChecked){
                return true
            } else
                Toast.makeText(this,"Verife votre  ",Toast.LENGTH_LONG).show();
                 return false

        }
            btnSubmit!!.setOnClickListener {

                if (!checkBoxA?.isChecked!! && !checkBoxF?.isChecked!! && !checkBoxE?.isChecked!!) {
                    Toast.makeText(this,"Verife votre  ",Toast.LENGTH_LONG).show();

                }
                if (!checkBoxM?.isChecked!! && !checkBoG?.isChecked!! && !checkBoxS?.isChecked!!) {
                    Toast.makeText(this,"Verife votre  ",Toast.LENGTH_LONG).show();

                } else {
                    val intent = Intent(this, FourthActivity::class.java).apply {
                        putExtra("FULLNAME", name)
                        putExtra("AGE", age)
                        putExtra("EMAIL", EMAIL)
                        putExtra("LANGAGE", langage)
                        putExtra("MUSIC", checkBoxM!!.isChecked)
                        putExtra("ARABIC", checkBoxA!!.isChecked)
                        putExtra("ENGLISH", checkBoxE!!.isChecked)
                        putExtra("FRENSH", checkBoxF!!.isChecked)
                        putExtra("SPORT", checkBoxS!!.isChecked)
                        putExtra("GAMES", checkBoG!!.isChecked)
                        putExtra("FLUTTER", Flutter?.progress.toString())
                        putExtra("ANDROID", Android?.progress.toString())
                        putExtra("IOS", ios?.progress.toString())


                    }
                    startActivity(intent)

                }

            }

    }


        }

