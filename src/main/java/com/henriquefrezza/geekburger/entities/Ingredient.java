package com.henriquefrezza.geekburger.entities;

import java.util.Objects;

public class Ingredient {
    private String ingredientID;
    private String name;

    public Ingredient(String ingredientID, String name) {
        this.ingredientID = ingredientID;
        this.name = name;
    }
    
    public Ingredient() {}

    public String getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(String ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingredient other = (Ingredient) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "ingredientID=" + ingredientID + ", name=" + name + '}';
    }

    
    
}