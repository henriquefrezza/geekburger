package com.henriquefrezza.geekburger.resources;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.henriquefrezza.geekburger.entities.Ingredient;
import com.henriquefrezza.geekburger.entities.Item;
import com.henriquefrezza.geekburger.entities.Product;


@Configuration
public class ProductsListResource{ 

    @Bean(name = "getProducts")
    public ArrayList<Product> createProductsList() {

	Ingredient soy = new Ingredient("" + UUID.randomUUID(), "Soy");
    Ingredient beef = new Ingredient("" + UUID.randomUUID(), "Beef");
    Ingredient lettuce = new Ingredient("" + UUID.randomUUID(), "Lettuce");
    Ingredient pickle = new Ingredient("" + UUID.randomUUID(), "Pickle");
    Ingredient dairy = new Ingredient("" + UUID.randomUUID(), "Dairy");
    Ingredient gluten = new Ingredient("" + UUID.randomUUID(), "Gluten");
    Ingredient sugar = new Ingredient("" + UUID.randomUUID(), "Sugar");
    Ingredient spinach = new Ingredient("" + UUID.randomUUID(), "Spinach");

    ArrayList<Ingredient> burger1List = new ArrayList<>();
    ArrayList<Ingredient> burger2List = new ArrayList<>();
    ArrayList<Ingredient> milkshakeList = new ArrayList<>();
    ArrayList<Ingredient> friesList = new ArrayList<>();
    ArrayList<Ingredient> salad1List = new ArrayList<>();
    ArrayList<Ingredient> salad2List = new ArrayList<>();

    burger1List.add(beef);
    burger1List.add(gluten);

    burger2List.add(soy);

    milkshakeList.add(dairy);
    milkshakeList.add(sugar);

    friesList.add(gluten);
    friesList.add(soy);

    salad1List.add(lettuce);

    salad2List.add(spinach);
    salad2List.add(pickle);

    Item burger1Item = new Item("" + UUID.randomUUID(), "hamburguer", burger1List);
    Item burger2Item = new Item("" + UUID.randomUUID(), "hamburguer", burger2List);
    Item milkshakeItem = new Item("" + UUID.randomUUID(), "milkshake", milkshakeList);
    Item friesItem = new Item("" + UUID.randomUUID(), "fries", friesList);
    Item salad1Item = new Item("" + UUID.randomUUID(), "salad1", salad1List);
    Item salad2Item = new Item("" + UUID.randomUUID(), "salad2", salad2List);

    ArrayList<Item> burger1ItemList = new ArrayList<>();
    ArrayList<Item> burger2ItemList = new ArrayList<>();
    ArrayList<Item> milkshakeItemList = new ArrayList<>();
    ArrayList<Item> friesItemList = new ArrayList<>();

    burger1ItemList.add(burger1Item);
    burger1ItemList.add(salad1Item);

    burger2ItemList.add(burger2Item);
    burger2ItemList.add(salad2Item);

    milkshakeItemList.add(milkshakeItem);

    friesItemList.add(friesItem);

    Product product1 = new Product("" + UUID.randomUUID(), "Burger1", "/images/burger1.png", 20.0, "burgerArea", burger1ItemList);
    Product product2 = new Product("" + UUID.randomUUID(), "Burger2", "/images/burger2.png", 25.0, "burgerArea", burger2ItemList);
    Product product3 = new Product("" + UUID.randomUUID(), "Milkshake", "/images/milkshake.png", 12.0, "icecreamArea", milkshakeItemList);
    Product product4 = new Product("" + UUID.randomUUID(), "Fries", "/images/fries.png", 7.0, "fryingArea", friesItemList);

    ArrayList<Product> productsList = new ArrayList<>();

    productsList.add(product1);
    productsList.add(product2);
    productsList.add(product3);
    productsList.add(product4);
    
    return productsList;
    }
}
