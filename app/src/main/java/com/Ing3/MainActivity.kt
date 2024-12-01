package com.Ing3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.helloing3.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val btnGallery: Button= findViewById(R.id.button)
        val btnSubjects: Button = findViewById(R.id.button2)
        val tvSalutation: TextView = findViewById(R.id.textView2)
        val btnSendEmail: Button= findViewById(R.id.btnSendMail)


        btnGallery.setOnClickListener{

           var intent= Intent(this, GalleryActivity:: class.java)
            startActivity(intent)
        }

        btnSubjects.setOnClickListener{
            var intent= Intent(this, SubjectsActivity:: class.java)
            startActivity(intent)

        }
        btnSendEmail.setOnClickListener{
            sendEmail("")
        }


    }
    fun sendEmail(emailAddress: String){
        val intent=Intent(Intent.ACTION_SEND)
        intent.type="Text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, emailAddress)
        intent.putExtra(Intent.EXTRA_TEXT, "HOW ARE YOU")
        if(intent.resolveActivity(packageManager)!=null){
            startActivity(intent)
        }
    }



}