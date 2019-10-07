package com.henriquefrezza.geekburger.resources;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.henriquefrezza.geekburger.entities.Ingredient;
import com.henriquefrezza.geekburger.entities.Restriction;

@Configuration
public class ClientResource {
    
    @Bean(name = {"getClientRestrictions", "restriction"})
    @Scope(value = "prototype") 
    public Restriction getClientRestrictions(String restriction){
    ArrayList<Ingredient> clientRestrictionList = new ArrayList<>();
    Ingredient ingredient = new Ingredient();
    switch (restriction) {
    	case "SOY":
    		ingredient.setIngredientID("" + UUID.randomUUID());
    		ingredient.setName("Soy");
    	break;
		case "LETUCCE":
			ingredient.setIngredientID("" + UUID.randomUUID());
			ingredient.setName("Lettuce");
		break;
		case "DAIRY":
			ingredient.setIngredientID("" + UUID.randomUUID());
			ingredient.setName("Dairy");
		break;
		case "PICKLE":
			ingredient.setIngredientID("" + UUID.randomUUID());
			ingredient.setName("Pickle");
		break;
		case "SUGAR":
			ingredient.setIngredientID("" + UUID.randomUUID());
			ingredient.setName("Sugar");
		break;
		case "GLUTEN":
			ingredient.setIngredientID("" + UUID.randomUUID());
			ingredient.setName("Gluten");
		break;
		case "SPINACH":
			ingredient.setIngredientID("" + UUID.randomUUID());
			ingredient.setName("Spinach");
		break;
		case "BEEF":
			ingredient.setIngredientID("" + UUID.randomUUID());
			ingredient.setName("Beef");
		break;
		default:;
    }
    clientRestrictionList.add(ingredient);
    Restriction clientRestriction = new Restriction("" + UUID.randomUUID(), clientRestrictionList);
    return clientRestriction;
    }
}
