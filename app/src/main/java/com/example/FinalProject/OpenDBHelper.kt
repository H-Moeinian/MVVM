package com.example.FinalProject

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.FinalProject.MovieDatabase.Search;
import java.util.ArrayList;

class OpenDBHelper(
    context: Context?
) : SQLiteOpenHelper(context,null, null,1) {

    val TABLE_NAME = "movies_table"
    val COL_1 = "ID"
    val COL_2 = "TITLE"
    val COL_3 = "YEAR"
    val COL_4 = "POSTER"

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY =
            " CREATE TABLE $TABLE_NAME ( $COL_1 INTEGER PRIMARY KEY AUTOINCREMENT,$COL_2 TEXT,$COL_3 TEXT, $COL_4 TEXT)"
        db?.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun addData(movie: Search) {
        val db = this.getWritableDatabase()

//        if (movie.title.contains("'")) {
//            movie.title.replace("'", "''")
//        }
        val insertQuery =
            "INSERT INTO $TABLE_NAME($COL_2 , $COL_3 , $COL_4 ) VALUES( '${movie.title}' , '${movie.year}','${movie.poster}')"
        db.execSQL(insertQuery)
        db.close()
    }

    fun getData(): ArrayList<Search> {
        val GET_DATA_QUERY =
            "SELECT DISTINCT TITLE,YEAR,POSTER FROM $TABLE_NAME"

        val search = ArrayList<Search>()

        val db = this.getReadableDatabase()
        val cursor = db.rawQuery(GET_DATA_QUERY, null)

        while (cursor.moveToNext()) {
            val se = Search()
            se.title = cursor.getString(0)
            se.year = cursor.getString(1)
            se.poster = cursor.getString(2)
            search.add(se)
        }
        db.close()

        return search
    }
}