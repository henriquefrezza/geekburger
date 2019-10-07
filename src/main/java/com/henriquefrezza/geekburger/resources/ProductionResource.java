package com.henriquefrezza.geekburger.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.henriquefrezza.geekburger.entities.Production;
import com.henriquefrezza.geekburger.ui.ProductionUI;

@Configuration
public class ProductionResource {
	
    @Bean(name = "getProduction")
    public Production getProduction() {
        return new Production(true, true, true);
    }
        
    @Bean(name = "getProductionUI")
    public ProductionUI getProductionUI() {
    	return new ProductionUI();    	
    }
    
}
