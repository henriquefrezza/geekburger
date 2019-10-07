package com.henriquefrezza.geekburger.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PaymentResource {
    
    @Bean(name = {"getPayment", "senha"})
    @Scope(value = "prototype")
    public boolean getPayment(String senha){
    	return senha.equals("PAGO");
    }
}
