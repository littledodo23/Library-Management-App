package com.example.user.library

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_list.*

class BookList : AppCompatActivity() {
    var db = DBHelper(this)
    internal var lst = ArrayList<Book>()
    internal lateinit var adapter:BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        show()

        button3.setOnClickListener {
            val name = editText5.text.toString()
            val lst= db.searchBook(name)
            adapter= BookAdapter(this,lst)
            listView.adapter=adapter
            adapter.notifyDataSetChanged()
        }

    }
    fun show(){
        val lst= db.allBook()
        adapter= BookAdapter(this,lst)
        listView.adapter=adapter
        adapter.notifyDataSetChanged()

    }
}
