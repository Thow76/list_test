package com.example.list_test.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.list_test.R;
import com.example.list_test.model.Food;
import com.example.list_test.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME , null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create table _name(id, name, expiry_date)
        String CREATE_FOOD_ITEM_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NAME + " TEXT,"
                + Util.KEY_EXPIRY_DATE + " TEXT" + ")";
        db.execSQL(CREATE_FOOD_ITEM_TABLE); //Table created

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf(R.string.db_drop);
        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});

        //Create a table again
        onCreate(db);
    }

     /*
    CRUD = Create, Read, Update, Delete
     */

    public void addFoodItem(Food food){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, food.getFood_item());
        values.put(Util.KEY_EXPIRY_DATE, food.getExpiry_date());

        //Insert to row
        db.insert(Util.TABLE_NAME, null, values);
        Log.d("DBHandler", "addFoodItem: " + "item added");
        //Close connection
        db.close();
    }

    public Food getFood(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME,
                new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_EXPIRY_DATE},
                Util.KEY_ID +"=?", new String[]{String.valueOf(id)},
                null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Food food = new Food();
        food.setId(Integer.parseInt(cursor.getString(0)));
        food.setFood_item(cursor.getString(1));
        food.setExpiry_date(cursor.getString(2));

        return food;
    }

    //Get all contacts
    public List<Food> getAllFoodItems() {
        List<Food> foodList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        //Select all contacts
        String selectAll = "SELECT* FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        if (cursor.moveToFirst()) {
            do {
                Food food = new Food();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setFood_item(cursor.getString(1));
                food.setExpiry_date(cursor.getString(2));

                //add food object to list
                foodList.add(food);
            }while(cursor.moveToNext());
        }
        return foodList;
    }

    //Update food list

    public int updateFoodList(Food food){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, food.getFood_item());
        values.put(Util.KEY_EXPIRY_DATE, food.getExpiry_date());

        //Update row
        //Update(tablename, values, where id = 43)
        return db.update(Util.TABLE_NAME, values, Util.KEY_ID + "=?",
                new String[]{String.valueOf(food.getId())});
    }

    //Delete food item

    public void deleteFoodItem(Food food) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?",
                new String[]{String.valueOf(food.getId())});

        db.close();
    }

    //Get food item count
    public int getFoodItemCount(){
        String countQuery = "SELECT* FROM " + Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }
}
