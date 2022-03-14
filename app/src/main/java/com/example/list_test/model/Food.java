package com.example.list_test.model;

public class Food {

    private int id;
    private String food_item;
    private String expiry_date;

    public Food(String food_item, String expiry_date) {
        this.food_item = food_item;
        this.expiry_date = expiry_date;

    }

    public Food() {
    }

    public Food(int id, String food_item, String expiry_date) {
        this.id = id;
        this.food_item = food_item;
        this.expiry_date = expiry_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood_item() {
        return food_item;
    }

    public void setFood_item(String food_item) {
        this.food_item = food_item;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}

