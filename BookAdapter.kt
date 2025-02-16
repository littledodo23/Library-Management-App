package com.example.user.library

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.iteam.view.*

class BookAdapter(context: Context, objects: ArrayList<Book>) : ArrayAdapter<Book>(context, 0, objects) {
    val db = DBHelper(context)
    var lst= objects
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.iteam,parent,false)
        view.textView2.text=getItem(position)!!.name
        view.textView4.text=getItem(position)!!.cetegory

                view.deleteBtn.setOnClickListener {
                    val builder= AlertDialog.Builder(context)
                .setPositiveButton("موافق"){_:DialogInterface,_:Int ->
        db.deleteBook(context,getItem(position)!!.id)
                    lst.removeAt(position)
                    notifyDataSetChanged()
    }
                .setNeutralButton("لا"){_:DialogInterface,_:Int ->}
                .setMessage("هل تريد حذف بيانات الكتاب ${getItem(position)!!.name}")
                .setTitle("تنبيه")
                .create()
                .show()
                }
        view.detalis.setOnClickListener {
            val intent = Intent(context,detalis::class.java)
          intent.putExtra("name",getItem(position)!!.name)
            intent.putExtra("id",getItem(position)!!.id)
            intent.putExtra("author",getItem(position)!!.author)
            intent.putExtra("cetegory",getItem(position)!!.cetegory)
            context.startActivity(intent)
        }
        return view
    }

}