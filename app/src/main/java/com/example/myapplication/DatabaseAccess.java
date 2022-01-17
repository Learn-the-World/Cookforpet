package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //private constructor so that object creation from outside the class is avoided
    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //to return the single instance of database
    public static DatabaseAccess getInstance(Context context){
        if (instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    //to open the database
    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    //closing the database connection
    public void close(){
        if (db!=null){
            this.db.close();
        }
    }

    //now lets create a method to query and return the result from database

    public String getRecipeName(String code){
        c = db.rawQuery("select recipe_name from recipe where recipe_code = '"+code+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String recipeCode = c.getString(0);
            buffer.append(""+recipeCode);
        }
        return buffer.toString();
    }

    public String getRecipeImg(String code){
        c = db.rawQuery("select img_main from recipe where recipe_code = '"+code+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String recipeCode = c.getString(0);
            buffer.append(""+recipeCode);
        }
        return buffer.toString();
    }

    public ArrayList<String> getRecipeCode(String mat){
        c = db.rawQuery("SELECT recipe_code" + " FROM materials" +
                " WHERE mat_name='"+mat+"'", new String[]{});
        ArrayList<String> code_list = new ArrayList<String>();
        while(c.moveToNext()){
            String recipeCode = c.getString(0);
            code_list.add(recipeCode);
        }
        return code_list;
    }

    public Integer getResultSum(String mat){
        c = db.rawQuery("SELECT recipe_code" + " FROM materials" +
                " WHERE mat_name='"+mat+"'", new String[]{});
        Integer count = c.getCount();
        return count;
    }
}
