package com.example.user.library

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
val db = DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2.setOnClickListener {
            val intent= Intent(this,BookList::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
        val name = editText2.text.toString()
        val id = editText.text.toString().toInt()
        val author= editText3.text.toString()
        val cetegory=editText4.text.toString()
        db.addBook(id,name,author,cetegory)
        val builder= AlertDialog.Builder(this)
                .setMessage("تمت اضافة بيانات الكتاب $name")
                .setTitle("تنويه")
                .setNegativeButton("موافق"){_:DialogInterface,_:Int->

                }
                .create()
                .show()


    }}
}
