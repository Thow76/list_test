package com.example.list_test.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView foodName;
        public TextView expiryDate ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodName = itemView.findViewById(R.id.food);
            expiryDate = itemView.findViewById(R.id.expiry);
        }
    }
}
