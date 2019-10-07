package com.henriquefrezza.geekburger.entities;

import java.util.ArrayList;

public class Restriction {
    private String idRestriction;
    private ArrayList<Ingredient> restrictionItems;

    public Restriction(String idRestriction, ArrayList<Ingredient> restrictionItems) {
        this.idRestriction = idRestriction;
        this.restrictionItems = restrictionItems;
    }
    
    public Restriction() {};

    public String getIdRestriction() {
        return idRestriction;
    }

    public void setIdRestriction(String idRestriction) {
        this.idRestriction = idRestriction;
    }

    public ArrayList<Ingredient> getRestrictionItems() {
        return restrictionItems;
    }

    public void setRestrictionItems(ArrayList<Ingredient> restrictionItems) {
        this.restrictionItems = restrictionItems;
    }
    
    public ArrayList<Product> filter(ArrayList<Product> allProducts, Production production){
        ArrayList<Product> filteredList = new ArrayList<>(allProducts); 
        allProducts.forEach((f) 
                -> {f.getItems().forEach((g) 
                        -> {g.getIngredients().forEach((h) 
                                -> {restrictionItems.forEach((i) 
                                        -> {boolean a = h.equals(i);
                                                if (a == true && filteredList.contains(f)){
                                                    filteredList.remove(f);}});});});});
        return filteredList;
    }

    @Override
    public String toString() {
        return "Restriction{" + "idRestriction=" + idRestriction + ", restrictionItems=" + restrictionItems + '}';
    }

    
}