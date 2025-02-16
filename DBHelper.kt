package com.example.user.library

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context,DBHelper.DATABASE_NAME,null,DBHelper.DATABASE_VERSION) {
    companion object {
        private val DATABASE_NAME= "library_db.db"
        private val DATABASE_VERSION=1
        private val table = "library"
        private val Col_id= "ID"
        private val Col_name="Name"
        private val Col_author="AUTHOR"
        private val Col_ceterogy="CETEGORY"
        private val creat = "CREATE TABLE $table($Col_id INTEGER PRIMARY KEY, "+
                "$Col_name TEXT NOT NULL, "+
                "$Col_author TEXT, "+
                "$Col_ceterogy TEXT);"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(creat)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

        p0!!.execSQL("DROP TABLE IF EXISTS $table")
        onCreate(p0)
    }
    fun addBook(id:Int,name:String,author:String,cetegory:String){
        val db = writableDatabase
        val values=ContentValues()
        values.put(Col_id,id)
        values.put(Col_author,author)
        values.put(Col_name,name)
        values.put(Col_ceterogy,cetegory)
        db.insert(table,null,values)
        db.close()
    }
    fun deleteBook(context: Context,id: Int){
        val db =writableDatabase
        db.delete(table,"ID = ?", arrayOf(id.toString()))
        db.close()
    }
    fun allBook():ArrayList<Book>{
        val lst = ArrayList<Book>()
        val db = writableDatabase
        val query="select * from $table where 1"
        val c = db.rawQuery(query,null)
        if (c.count!=0){
            c.moveToFirst()
            do {
                val book =Book(c.getInt(c.getColumnIndex(Col_id)),c.getString(c.getColumnIndex(Col_name))
                        ,c.getString(c.getColumnIndex(Col_author)),c.getString(c.getColumnIndex(Col_ceterogy)))
                lst.add(book)
            }while (c.moveToNext())
        }
        return lst
        db.close()

    } fun searchBook(name: String):ArrayList<Book>{
        val lst = ArrayList<Book>()
        val db = writableDatabase
        val query="select * from $table where $Col_name=\"$name\";"
        val c = db.rawQuery(query,null)
        if (c.count!=0){
            c.moveToFirst()
            do {
                val book =Book(c.getInt(c.getColumnIndex(Col_id)),c.getString(c.getColumnIndex(Col_name))
                        ,c.getString(c.getColumnIndex(Col_author)),c.getString(c.getColumnIndex(Col_ceterogy)))
                lst.add(book)
            }while (c.moveToNext())
        }
        return lst
        db.close()

    }
}