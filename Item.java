package com.example.myfirstapp;

public class Item  {

    private String name = "";

    public Item() {
    }

    public Item(String name){
        this.name = name;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

}
