package com.example.user.library

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalis.*

class detalis : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalis)
        textView6.text=intent.extras!!.getString("name")
        textView8.text= intent.extras!!.getInt("id").toString()
        textView10.text=intent.extras!!.getString("author")
        textView12.text=intent.extras!!.getString("cetegory")
        button4.setOnClickListener {
            val intent = Intent(this,BookList::class.java)
            startActivity(intent)
        }

    }
}
