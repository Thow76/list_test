package com.example.list_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.list_test.data.DatabaseHandler;
import com.example.list_test.model.Food;


import java.util.ArrayList;
import java.util.List;

public class ListPage extends AppCompatActivity {

    //private ArrayList<String> foodArrayList;

   //public ListPage(ArrayList<String> foodArrayList) {
    // this.foodArrayList = foodArrayList;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_page_activity);
        DatabaseHandler db = new DatabaseHandler(ListPage.this);

        //List<Food> foodList = db.getAllFoodItems();
        //for(Food food: foodList) {

          //  foodArrayList.add(food.getFood_item());
}
}