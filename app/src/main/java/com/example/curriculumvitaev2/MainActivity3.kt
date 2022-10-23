package com.example.curriculumvitaev2

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.Intents.Insert.EMAIL
import android.provider.Settings.NameValueTable.NAME
import android.provider.Telephony.Carriers.PASSWORD
import android.view.Window
import android.widget.*
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.NonCancellable.cancel

const val IS_REMEMBRED = "IS_REMEMBRED"
class MainActivity3 : AppCompatActivity()  {
    private var checkBoxA : CheckBox? = null
    private var checkBoxF : CheckBox? = null
    private var checkBoxE : CheckBox? = null
    private var checkBoxM : CheckBox? = null
    private var checkBoxS : CheckBox? = null
    private var cbRememberMe : CheckBox? = null
    private var checkBoG : CheckBox? = null
    private var image1: ImageButton? = null
    private var exit: ImageButton? = null
    private var image: ImageButton? = null
    private var age: String? = ""
    private var ios :SeekBar?=null
    private var Flutter :SeekBar?=null
    private var Android :SeekBar?=null
    private var toolbar: Toolbar? = null
    private var btnSubmit : Button? = null
    private var btnCareer : Button? = null
    private var btnHobbies : Button? = null

    private var langage = ""
    private var hobbies = ""
    lateinit var mSharedPref: SharedPreferences
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
        btnCareer = findViewById(R.id.career)
        cbRememberMe = findViewById(R.id.RemembreMe)
        checkBoxM = findViewById(R.id.Music)
        image1 = findViewById(R.id.info)
        image = findViewById(R.id.info)
        exit = findViewById(R.id.exit)
        ios=findViewById(R.id.seekI)
        Flutter=findViewById(R.id.seekF)
        Android=findViewById(R.id.seekA)
        toolbar = findViewById(R.id.toolbar);
        val name = intent.getStringExtra("FULLNAME").toString()
        val EMAIL = intent.getStringExtra("EMAIL").toString()
        setSupportActionBar(toolbar)


        image1!!.setOnClickListener() {
            val intent = Intent(this, FourthActivity::class.java).apply {

                putExtra("MUSIC", checkBoxM!!.isChecked)
                putExtra("SPORTS",checkBoxS!!.isChecked)
                putExtra("GAMES", checkBoG!!.isChecked)
                putExtra("FLUTTER", Flutter?.progress)
                putExtra("ANDROID", Android?.progress)
                putExtra("IOS", ios?.progress)
                putExtra("frensh",checkBoxF?.isChecked)
                putExtra("arabic", checkBoxA?.isChecked)
                putExtra("english", checkBoxE?.isChecked)

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
        mSharedPref = getSharedPreferences("login", MODE_PRIVATE);
        fun navigate(){


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
                       putExtra("Android", Android!!.progress.toString())
                        putExtra("iOS", ios!!.progress.toString())
                       putExtra("Flutter", Flutter!!.progress.toString())


                    }
                    startActivity(intent)

                }

            }


         fun doLogin(){

                if (cbRememberMe!!.isChecked){
                    //TODO 4 "Edit the SharedPreferences by putting all the data"
                    mSharedPref.edit().apply{
                        putBoolean(IS_REMEMBRED, true)
                        putString("FULLNAME", name)
                        putString("AGE", age)
                    }.apply()

                }else{
                    mSharedPref.edit().clear().apply()
                }

                navigate()

            }

        //TODO 3 "Test in the SharedPreferences if there's data"
        if (mSharedPref.getBoolean(IS_REMEMBRED, false)){
            navigate()
        }

        btnSubmit!!.setOnClickListener{
            doLogin()
        }

    }


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

    }



