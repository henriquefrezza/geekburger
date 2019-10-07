package com.henriquefrezza.geekburger.entities;

import java.util.ArrayList;

public class Item {
	private String itemId;
        private String name;
        private ArrayList<Ingredient> ingredients;

    public Item(String name, String itemId, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.itemId = itemId;
        this.ingredients = ingredients;
    }    

    Item() {
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", name=" + name + ", ingredients=" + ingredients + '}';
    }
	
        
}