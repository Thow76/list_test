package com.example.list_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.example.list_test.Adapter.RecyclerViewAdapter;
import com.example.list_test.data.DatabaseHandler;
import com.example.list_test.model.Food;


import java.util.ArrayList;
import java.util.List;

public class ListPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<String> foodArrayList;
    private ArrayAdapter<String> arrayAdapter;

   //public ListPage(ArrayList<String> foodArrayList) {
    // this.foodArrayList = foodArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_page_activity);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        foodArrayList = new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(ListPage.this);


        //List<Food> foodList = db.getAllFoodItems();
        //for(Food food: foodList) {

          //  foodArrayList.add(food.getFood_item());
}
}