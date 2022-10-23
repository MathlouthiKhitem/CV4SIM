package com.example.curriculumvitaev2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

private var point: ImageButton? = null
private var toolbar :Toolbar? = null
class career : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
//       toolbar = findViewById(R.id.toolbar3)
//        toolbar!!.inflateMenu(R.menu.meun)
       toolbar = findViewById(R.id.toolbar3)
        setSupportActionBar(toolbar)
        val btnexperience = findViewById<Button>(R.id.experience)
        val btneducation = findViewById<Button>(R.id.education)
        toolbar!!.setNavigationOnClickListener {
            onBackPressed();

        }
        toolbar!!.inflateMenu(R.menu.meun);

        btnexperience.setOnClickListener {
            changeFragment(Recyclerview(), "")

        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.meun, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addeducation -> {
                val intent = Intent(this.applicationContext, Education::class.java)
                startActivity(intent)
//                Toast.makeText(this,"Education button clicked",Toast.LENGTH_LONG).show()
//                println("Test eD")

                return true
            }
            R.id.addexperience -> {
                val intent = Intent(this, Experiencee::class.java)
                startActivity(intent)
//                Toast.makeText(this,"Experience button clicked",Toast.LENGTH_LONG).show()
//                println("Test ex")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun changeFragment(fragment: Fragment, name: String) {
        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, fragment)
                .commit()
        else {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, fragment)
                .addToBackStack(name).commit()
        }
    }

//        point = findViewById(R.id.point);
//        point!!.setOnClickListener(){
//            AlertDialog.Builder(this)
//                .setCancelable(false)
//                .setPositiveButton("addedcation", object : DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//                        val intent = Intent(this@career, Education::class.java).apply {
//
//                        }
//                        startActivity(intent)
//                    }
//                }).setNegativeButton("addExprencece", object : DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//                        val intent = Intent(this@career, Experiencee::class.java).apply {
//
//                        }
//                        startActivity(intent)
//
//                    }
//                }
//
//                )
//                .show()
//        }



   }