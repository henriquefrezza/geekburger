package com.henriquefrezza.geekburger.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.henriquefrezza.geekburger.ui.OrdersUI;

@Configuration
public class OrdersUIResource {

    @Bean(name = "createOrdersUI")
    public OrdersUI createOrdersUI() {
    	System.setProperty("java.awt.headless", "false");
        return new OrdersUI();
    }

}
