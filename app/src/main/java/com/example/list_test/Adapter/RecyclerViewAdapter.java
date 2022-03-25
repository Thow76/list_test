package com.example.list_test.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.list_test.DetailsActivity;
import com.example.list_test.R;
import com.example.list_test.model.Food;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Food> foodList;

    public RecyclerViewAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_item_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            Food food = foodList.get(position);// each contact object inside of our list

            viewHolder.foodName.setText(food.getFood_item());
            viewHolder.expiryDate.setText(food.getExpiry_date());
    }

    @Override
    public int getItemCount() {

        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView foodName;
        public TextView expiryDate;
        public ImageView tickBox;
        public TextView foodTag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            foodName = itemView.findViewById(R.id.food);
            expiryDate = itemView.findViewById(R.id.expiry);
            tickBox = itemView.findViewById(R.id.tickBox);
            foodTag = itemView.findViewById(R.id.foodTag);
            //itemView.setOnClickListener(this);
            tickBox.setOnClickListener(this);
            foodName.setOnClickListener(this);
            foodTag.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        int position = getAdapterPosition();
        Food food = foodList.get(position);

            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name", food.getFood_item());
            intent.putExtra("expiry", food.getExpiry_date());

            context.startActivity(intent);
        }
    }
}


