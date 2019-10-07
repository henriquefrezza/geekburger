package com.henriquefrezza.geekburger.entities;

import java.util.ArrayList;

public class Production {
    private boolean burgerArea;
    private boolean fryingArea;
    private boolean icecreamArea;

    public Production(boolean burgerArea, boolean fryingArea, boolean icecreamArea) {
        this.burgerArea = burgerArea;
        this.fryingArea = fryingArea;
        this.icecreamArea = icecreamArea;
    }

    public boolean isBurgerArea() {
        return burgerArea;
    }

    public void setBurgerArea(boolean burgerArea) {
        this.burgerArea = burgerArea;
    }

    public boolean isFryingArea() {
        return fryingArea;
    }

    public void setFryingArea(boolean fryingArea) {
        this.fryingArea = fryingArea;
    }

    public boolean isIcecreamArea() {
        return icecreamArea;
    }

    public void setIcecreamArea(boolean icecreamArea) {
        this.icecreamArea = icecreamArea;
    }
    
    public ArrayList<Product> filter (ArrayList<Product> allProducts){
        ArrayList<Product> filteredList = new ArrayList<>(allProducts);
        allProducts.forEach((f) -> {
            if(f.getProductionArea().equalsIgnoreCase("burgerArea") && burgerArea == false) filteredList.remove(f);
            else if(f.getProductionArea().equalsIgnoreCase("fryingArea") && fryingArea == false) filteredList.remove(f);
            else if(f.getProductionArea().equalsIgnoreCase("icecreamArea") && icecreamArea == false) filteredList.remove(f);
        });
        return filteredList;
    }

    @Override
    public String toString() {
        return "Production{" + "burgerArea=" + burgerArea + ", fryingArea=" + fryingArea + ", icecreamArea=" + icecreamArea + '}';
    }
    
    

}