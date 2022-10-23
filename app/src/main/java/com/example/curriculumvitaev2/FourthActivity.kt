package com.example.curriculumvitaev2

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle

import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar;
import com.example.curriculumvitae2.BlankFragment3

class FourthActivity: AppCompatActivity() {
    private var name : String? = ""
    private var email : String? = ""
    private var age : String? = ""
    private var image : String? = null
    private var txtview1: TextView? = null
    private var txtview2: TextView? = null
    private var avatar: ImageView? = null
    private  var toolbar : Toolbar? = null
    private var ios: SeekBar? = null
    private var btnSkills: Button? = null
    private var exit1: ImageButton? = null
    private var Career: Button? = null
    private var btnHobbies: Button? = null
    private var btnLanguages: Button? = null
    private var music: Boolean = true
    private var sport: Boolean = true
    private var games: Boolean = true
    private var music1: CheckBox? = null
    private var sport1: CheckBox? = null
    private var games1: CheckBox? = null
    private var checkBoxA: CheckBox? = null
    private var checkBoxF: CheckBox? = null
    private var checkBoxE: CheckBox? = null
    private var ios1: Int? = null
    private var flutter1: Int? = null
    private var android1 : Int? = null
    private var progressF: Int? = null
    private var progressA: Int? = null
    private var progressI: Int? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fourth)
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar)
        toolbar!!.setTitle("CurriculumVitaeV2")
        name = intent.getStringExtra("FULLNAME");
        checkBoxA = findViewById(R.id.Arabic)
        checkBoxF =  findViewById(R.id.French)
        checkBoxE =  findViewById(R.id.English)
        avatar  =  findViewById(R.id.avatar)
        Career  =  findViewById(R.id.career)
        image = intent.getStringExtra("IMAGE")
        avatar!!.setImageResource(R.drawable.screenshot_2022_10_01_at_15_54_51)
        email = intent.getStringExtra("EMAIL");
        age = intent.getStringExtra("AGE");
        txtview1 = findViewById(R.id.NameFin)
        txtview2 = findViewById(R.id.EmailFin)
        txtview1!!.setText(name)
        txtview2!!.setText(email)
        btnSkills = findViewById(R.id.skills);
        btnHobbies = findViewById(R.id.hobbies);
        btnLanguages = findViewById(R.id.languages);
        music = intent.getBooleanExtra("MUSIC" , false);
        sport =  intent.getBooleanExtra("SPORTS" , false );
        games =  intent.getBooleanExtra("GAMES" , false );
        val  arabic = intent.getBooleanExtra("ARABIC" , false);
        val frensh =  intent.getBooleanExtra("FRENSH" , false );
        val english =  intent.getBooleanExtra("ENGLISH" , false);
        music1 = findViewById(R.id.checkBoxM)
        sport1 = findViewById(R.id.checkBoxS)
        games1 = findViewById(R.id.checkBoxG)
        flutter1 =   intent.getIntExtra("FLUTTER" , 20);
        android1 =   intent.getIntExtra("ANDROID" , 20);
        ios1 =   intent.getIntExtra("IOS" , 20);
        exit1 = findViewById(R.id.exit);


Career!!.setOnClickListener(){
    val intent = Intent(this@FourthActivity, career::class.java).apply {

    }
    startActivity(intent)
}
        exit1!!.setOnClickListener(){
            AlertDialog.Builder(this@FourthActivity)
                .setTitle("Logout")
                .setMessage("are you sure you want to logout ")
                .setCancelable(false)
                .setPositiveButton("ok", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        getSharedPreferences("Login_pref", MODE_PRIVATE).edit().clear().apply()
                        finish()
                    }
                }).setNegativeButton("cancel", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {


                    }
                }

                )
                .show()
        }
        val fragment2 = BlankFragment2()
        btnHobbies!!.setOnClickListener{
            val bundle = Bundle();
            bundle.putBoolean("music", music)
            bundle.putBoolean("sport", sport)
            bundle.putBoolean("games", games)
            fragment2.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment2).commit()
        }

        val fragment3 = BlankFragment3()
        btnLanguages!!.setOnClickListener{
            val bundle = Bundle();
            bundle.putBoolean("arabic", arabic)
            bundle.putBoolean("english", english)
            bundle.putBoolean("frensh", frensh)
            fragment3.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment3).commit()
        }
        val fragment1 = BlankFragment()
        btnSkills!!.setOnClickListener{
            val bundle = Bundle();
            bundle.putInt("flutter", flutter1!!)
            bundle.putInt("android", android1!!)
            bundle.putInt("ios", ios1!!)
            fragment1.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment1).commit()
        }


    }


}